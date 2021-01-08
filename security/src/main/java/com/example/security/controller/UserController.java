package com.example.security.controller;

import com.example.security.model.User;
import com.example.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("")
    public ResponseEntity addUser(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "phone", required = false) String phone ){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setPhone(phone);
        userService.insert(user);
        return ResponseEntity.ok("添加成功");
    }

    @DeleteMapping("")
    public ResponseEntity deleteUser(@RequestParam(value = "userId", required = true) Integer userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping("")
    public ResponseEntity updateUser(
            @RequestParam(value = "userId", required = true)
                    Integer userId,
            @RequestParam(value = "userName", required = false)
                    String userName,
            @RequestParam(value = "password", required = false)
                    String password,
            @RequestParam(value = "phone", required = false)
                    String phone
    ){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setPhone(phone);
        userService.updateUser(user);
        return ResponseEntity.ok("更新成功");
    }

    @GetMapping("/getUsers")
    public ResponseEntity getUsers(){
        System.out.println("已经执行到controller层");
        return ResponseEntity.ok(userService.selectUsers());
    }

    @GetMapping("/getUserByName/{username}")
    @ResponseBody
    public User getUserByname(@PathVariable String username) {
        User user = userService.getUserByname(username);
        return user;
    }

    @GetMapping("/getAdmin")
    public ResponseEntity getAdmin() {
        User user = userService.getUserByname("admin");
        System.out.println(user.toString());
        return ResponseEntity.ok(user);
    }


}
