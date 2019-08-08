package com.example.springboot.controller;

import com.example.springboot.model.UserInfo;
import com.example.springboot.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userinfo")
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserInfo getUserInfoById(@PathVariable Integer id){
        UserInfo userInfo = userInfoService.getUserInfoById(id);
        return userInfo;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertUserInfo(@RequestParam(value = "username", required = true) @RequestBody String username,
                                 @RequestParam(value = "mobile", required = true) @RequestBody String mobile){
        System.out.print("调用 /userinfo/insert");
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setMobile(mobile);
        userInfoService.insertUserInfo(userInfo);

        return "/demo/add";
    }

    public List<UserInfo> findAllUserInfo(){
        List<UserInfo> userInfos = userInfoService.findAllUserInfo();
        return userInfos;
    }

    @RequestMapping(value = "/commit")
    public String commitPage(){
        System.out.print("index");
        return "demo";
    }
}
