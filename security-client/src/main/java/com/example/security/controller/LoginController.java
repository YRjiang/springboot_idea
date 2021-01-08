package com.example.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.security.entity.LoginParam;
import com.example.security.entity.ResponseResult;
import com.example.security.utils.HttpClientUtil;
import com.google.common.collect.Maps;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:8080/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;

    /*@Autowired
    TokenStore tokenStore;*/

    @PostMapping(value = "/user/login")
    @ResponseBody
    public ResponseResult<Map<String, String>> login(@RequestBody LoginParam loginParam) {
        Map<String, String> result = Maps.newHashMap();

        System.out.println("调用成功");

        List<NameValuePair> parametersBody = new ArrayList<>();
        parametersBody.add(new BasicNameValuePair("username", loginParam.getUsername()));
        parametersBody.add(new BasicNameValuePair("password", loginParam.getPassword()));
        parametersBody.add(new BasicNameValuePair("grant_type", oauth2GrantType));
        parametersBody.add(new BasicNameValuePair("client_id", oauth2ClientId));
        parametersBody.add(new BasicNameValuePair("client_secret", oauth2ClientSecret));

        String response = null;
        try {
            response = HttpClientUtil.postForm(URL_OAUTH_TOKEN, parametersBody);
            System.out.println("客户端登入返回数据： " + response);

            // 解析字符串为 json对象
            JSONObject jsonObject = JSONObject.parseObject(response);
            String accessToken = jsonObject.getString("access_token");
            result.put("token", accessToken);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseResult<Map<String, String>>(500, "登入成功", result);
    }

    @GetMapping(value = "/user/info")
    public ResponseResult<LoginParam> info() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginParam loginParam = new LoginParam();
        loginParam.setUsername(authentication.getName());

        return new ResponseResult<LoginParam> (200, "获取用户信息", loginParam);
    }

    /*@PostMapping(value = "/user/logout")
    public ResponseResult <Void> logout(HttpServletRequest request) {

        String accessToken = request.getParameter("access_token");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<Void> (200, "用户注销", null);
    }*/

}
