package com.example.cloudapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-provider", fallbackFactory = CityServiceFallbackFactory.class)
public interface ICityService {

    @GetMapping(value = "/get")
    public String get();

    @GetMapping(value = "/list")
    public String list();

    @GetMapping(value = "/add")
    public String add();

}
