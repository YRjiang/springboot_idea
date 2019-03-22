package com.example.connect_mysql.service;

import com.example.connect_mysql.model.User;

import java.util.List;

/**
 * Created by lxg
 * on 2017/2/21.
 */
public interface IUserService {

    User findByUsername(String name);

    List<User> findAll();

}
