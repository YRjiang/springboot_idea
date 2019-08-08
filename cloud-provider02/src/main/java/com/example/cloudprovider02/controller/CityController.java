package com.example.cloudprovider02.controller;

import com.example.cloudapi.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    ICityService cityService;

    @GetMapping(value = "/get")
    public String get(){
        String s = cityService.get();
        return s + "provider cityController   ---- 0202020202  ";
    }
}
