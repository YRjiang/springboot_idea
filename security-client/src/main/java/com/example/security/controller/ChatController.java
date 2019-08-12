package com.example.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.security.utils.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class ChatController {

    public final static String appId = "wx711b69a87a980f8a";
    public final static String appSecret = "0c3ea423046e73b0ffe0b0dcd74884b5";
    public final static String serviceUrl = "";

    @RequestMapping("/chat")
    public void login(HttpServletResponse response) throws IOException {

        String path = serviceUrl + "invoke";

        try {
            path = URLEncoder.encode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String url = "https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=" + appId +
                "&redirect_uri=" + path +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=" + "json" +
                "#wechat_redirect";

        response.sendRedirect(url);
    }

    @RequestMapping("invoke")
    public void oauthInvoke(HttpServletRequest request) {
        // 2.获得code
        String code = request.getParameter("code");
        String state = request.getParameter("state");

        System.out.println("接收到的数据: " + request.toString());
        System.out.println("code: " + code + ", state: ");

        // 3.通过code换取网页授权 access_token
        // 3.1 认证服务器
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=" + appId +
                "&secret=" + appSecret +
                "&code=" + code +
                "&grant_type=authorization_code";

        // 认证服务器 带着code 发送请求 得到 access_token
        JSONObject jsonObject = HttpUtil.httpRequest(url, "POST", null);
        System.out.println("认证服务器返回数据： " + jsonObject.toString());

        String accessToken = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");

        // 4.带着openid 和 access_token  获得资源信息
        // 请求资源服务器
        String getDataUrl = "https://api.weixin.qq.com/sns/userinfo" +
                "?access_token=" + accessToken +
                "&openid=" + openid +
                "&lang=zh_CN";

        JSONObject getDataObject = HttpUtil.httpRequest(getDataUrl, "GET", null);
        System.out.println(getDataObject.toString());

    }


}
