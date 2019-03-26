package com.example.cloudconsume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {

    private static final String REST_URL_PREFIX = "http://CLOUD-PROVIDER";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/consume")
    public String consume(String consume){
        String forObject = restTemplate.getForObject(REST_URL_PREFIX + "/provider", String.class);
        return "consume: " + consume + " 执行调用了服务： " + forObject;
    }

}
