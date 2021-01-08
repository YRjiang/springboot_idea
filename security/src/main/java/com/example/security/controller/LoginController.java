package com.example.security.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.security.model.LoginInfo;
import com.example.security.model.LoginParam;
import com.example.security.model.ResponseResult;
import com.example.security.utils.HttpClientUtil;
import com.google.common.collect.Maps;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:8083/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Resource
    public UserDetailsService userDetailsService;

    @Resource
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    TokenStore tokenStore;

    @PostMapping(value = "/user/login")
    @ResponseBody
    public ResponseResult<Map<String, String>> login(@RequestBody LoginParam loginParam) {
        Map<String, String> result = Maps.newHashMap();

        System.out.println("前端调用 登入成功");

        // 验证账号密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails == null || !bCryptPasswordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "账号或密码错误", null);
        }

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

        if (result == null) {
            return new ResponseResult<Map<String, String>>(400, "登入失败", null);
        }

        System.out.println("返回前端数据(result): " + result);
        return new ResponseResult<Map<String, String>>(20000, "登入成功", result);
    }

    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(authentication.getName());

        return new ResponseResult<LoginInfo> (ResponseResult.CodeStatus.OK, "获取用户信息", loginInfo);
    }

    @PostMapping(value = "/user/logout")
    public ResponseResult <Void> logout(HttpServletRequest request) {
        System.out.println("前端调用 退出成功");

        String accessToken = request.getParameter("access_token");
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<Void> (ResponseResult.CodeStatus.OK, "用户注销", null);
    }

    public static void main(String[] args) {
        System.out.println("解密2：" + new BCryptPasswordEncoder().encode("qwerty"));
    }

}
