/*
package com.example.security.controller;

import com.example.security.dao.UserRepository;
import com.example.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void save() {
        User users = new User();
        users.setName("小黑");
        users.setPassword("321654");

        this.userRepository.save(users);
    }

}
*/
