package com.example.cloudconsume.controller;

import com.example.cloudapi.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    ICityService cityService;

    @GetMapping(value = "/get")
    public String getCommonApi(){
        String getCity = cityService.get();
        System.out.print(getCity + "consume common !!");
        return getCity;
    }
}
