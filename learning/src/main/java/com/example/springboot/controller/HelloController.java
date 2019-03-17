package com.example.springboot.controller;

import com.example.springboot.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Spring Security 相关测试接口", description = "接口API")
public class HelloController {

    @ApiOperation(value="hello wrold!")
    @RequestMapping(value = "/hello/{id}", method = RequestMethod.POST)
    public String hello(@PathVariable(value = "id") Integer id){
        return "Hello World!";
    }

    @ApiOperation(value="创建用户")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User save(@ApiParam(value = "用户实体类", required = true) @RequestBody User user) {
        User uesr1 = new User();
        uesr1.setAge(18);
        uesr1.setName("fuck");
        uesr1.setSex(user.getSex());
        return uesr1;
    }

}
