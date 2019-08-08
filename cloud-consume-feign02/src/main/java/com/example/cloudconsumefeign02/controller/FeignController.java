package com.example.cloudconsumefeign02.controller;

import com.example.cloudconsumefeign02.service.IFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@RestController
public class FeignController {

    @Autowired
    IFeignService feignService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String sayHi(){
        String s = feignService.get();
        return s + "feign 02";
    }

    @GetMapping(value = "/provider/feign")
    public String getProvider(){
        String provider = feignService.provider();
        return provider + " feign provider success !!!";
    }

}
