package com.example.security.service;

import com.example.security.model.User;

import java.util.List;

public interface IUserService {

    int insert(User user);

    void deleteUserById(Integer id);

    void updateUser(User user);

    List<User> selectUsers();

    User getUserByname(String username);
}
