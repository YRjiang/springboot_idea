package com.example.cloudconsumefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-provider")   //要发现的服务
public interface ICityService {

    @GetMapping(value = "/provider")    // 要发现服务上的接口 feign 面向接口编程
    public String getProvider();

}
