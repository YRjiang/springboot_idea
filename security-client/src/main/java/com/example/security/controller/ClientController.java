package com.example.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.security.utils.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  oauth2.0 客户端
 *  直接请求本地 认证服务器 授权
 */
@Controller
public class ClientController {

    public final static String appId = "wx711b69a87a980f8a";
    public final static String appSecret = "0c3ea423046e73b0ffe0b0dcd74884b5";
    public final static String serviceUrl = "";

    @RequestMapping("/client")
    public void login(HttpServletResponse response) throws IOException {

        // 1.认证服务器 获取授权码 code
        String url = "http://localhost:8080/oauth/authorize" +
                "?client_id=client" +
                "&response_type=code";

        response.sendRedirect(url);
    }


    @RequestMapping("/clientInvoke")
    public ResponseEntity oauthInvoke(HttpServletRequest request) {
        // 2.通过回调地址 (此接口地址) 获得 认证服务器 派发的 code
        String code = request.getParameter("code");
        String state = request.getParameter("state");

        System.out.println("code: " + code + ", state: " + state);

        // 3.携带授权码 code 去 认证服务器 获取令牌 access_token
        String url = "http://client:secret@localhost:8080/oauth/token";

        // 认证服务器 带着code 发送请求 得到 access_token
        List<NameValuePair> parametersBody = new ArrayList<>();
        parametersBody.add(new BasicNameValuePair("code", code));
        parametersBody.add(new BasicNameValuePair("grant_type", "authorization_code"));

        String response = null;
        try {
            response = HttpClientUtil.postForm(url, parametersBody);
            System.out.println("认证服务器返回数据： " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 解析字符串为 json对象
        JSONObject jsonObject = JSONObject.parseObject(response);
        String accessToken = jsonObject.getString("access_token");
        String openid = jsonObject.getString("openid");

        // 4.携带令牌 access_token  向 资源服务器 获得资源信息
        //   资源服务器 会向 认证服务器 验证 令牌, 通过后则返回 权限范围内的数据
        String getDataUrl = "http://localhost:8081/contents/tbContent/getEntity/28";
        String postRequest = null;
        try {
            postRequest = HttpClientUtil.postRequest(getDataUrl, "application/json",
                    "bearer " + accessToken, null);
            System.out.println(postRequest.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(postRequest);
    }


}
