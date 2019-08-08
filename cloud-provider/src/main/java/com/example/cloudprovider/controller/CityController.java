package com.example.cloudprovider.controller;

import com.example.cloudapi.service.ICityService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    ICityService cityService;

    @GetMapping(value = "/get")
    @HystrixCommand(fallbackMethod = "getError")
    public String get(){
        String s = cityService.get();
        return s + "provider cityController ";
    }

    public String getError() {
        return "hystrix error !!! ------------ get Error";
    }
}
