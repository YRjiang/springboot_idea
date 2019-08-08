package com.example.security.service.impl;

import com.example.security.mapper.UserMapper;
import com.example.security.model.User;
import com.example.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> selectUsers() {
        return userMapper.selectUsers();
    }

    @Override
    public User getUserByname(String username) {
        return userMapper.getUserByname(username);
    }
}
