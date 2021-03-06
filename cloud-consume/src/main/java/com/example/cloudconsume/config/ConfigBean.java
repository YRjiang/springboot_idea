package com.example.cloudconsume.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced    // Spring Cloud Ribbon 是基于Netflix Ribbon 实现的一套 客户端 负载均衡 工具
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
