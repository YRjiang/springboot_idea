package com.example.springboot.controller;

import com.example.springboot.service.impl.QueryGrantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrantTypeController {

    @Autowired
    private QueryGrantTypeService queryGrantTypeService;

    @PostMapping("/grantType")
    public String test(String resourceName, String resourceId){
        return queryGrantTypeService.getResult(resourceName, resourceId);
    }

}
