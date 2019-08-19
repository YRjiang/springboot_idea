package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpClientController {

    @GetMapping("/httpRequest")
    public void httpRequest() {
        System.out.println("httpRequest..........");

    }



}
