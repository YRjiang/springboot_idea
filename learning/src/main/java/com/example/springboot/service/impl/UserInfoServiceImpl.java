package com.example.springboot.service.impl;

import com.example.springboot.mapper.UserInfoMapper;
import com.example.springboot.model.UserInfo;
import com.example.springboot.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoById(Integer id) {
        return userInfoMapper.getUserInfoById(id);
    }

    @Override
    public void insertUserInfo(UserInfo userInfo) {
        userInfoMapper.insertUserInfo(userInfo);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        return userInfoMapper.findAllUserInfo();
    }
}
