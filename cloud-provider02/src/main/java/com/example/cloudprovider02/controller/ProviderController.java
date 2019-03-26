package com.example.cloudprovider02.controller;

import com.example.cloudprovider02.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    IProviderService providerService;

    @GetMapping(value = "provider")
    public String  provider(){
        String provider = providerService.getProvider();
        return provider;
    }
}
