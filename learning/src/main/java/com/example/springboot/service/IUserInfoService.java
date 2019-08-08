package com.example.springboot.service;

import com.example.springboot.model.UserInfo;

import java.util.List;

public interface IUserInfoService {

    public UserInfo getUserInfoById(Integer id);

    public void insertUserInfo(UserInfo userInfo);

    public List<UserInfo> findAllUserInfo();

}
