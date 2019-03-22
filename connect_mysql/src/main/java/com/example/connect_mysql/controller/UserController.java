package com.example.connect_mysql.controller;

import com.example.connect_mysql.mapper.UserRepository;
import com.example.connect_mysql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //将方法的结果进行缓存   key = "#id"; #id 相当于 #root.args[0]
    //@Cacheable(cacheNames = {"emp"})
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findOneCity(@PathVariable Integer id) {//@RequestParam(value = "cityName", required = true) String userName
        System.out.print("查询用户, id: " + id);
        return userRepository.findAll().get(id);
    }

    // 定时任务
    //@Scheduled(cron = "*/10 * * * * ?")
    /*public void cronTask(){
        System.out.print("cronTask --- 执行 ....");
    }*/

}
