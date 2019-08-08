package com.example.cloudconsumefeign02.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@FeignClient(value = "cloud-provider")
public interface IFeignService {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    String get();

    @GetMapping(value = "/provider")
    public String  provider();
}
