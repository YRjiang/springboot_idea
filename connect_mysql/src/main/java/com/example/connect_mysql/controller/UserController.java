package com.example.connect_mysql.controller;

import com.example.connect_mysql.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*@RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public User findOneCity(@RequestParam(value = "cityName", required = true) String userName) {//
        return userRepository.findByName(userName);
    }*/

}
