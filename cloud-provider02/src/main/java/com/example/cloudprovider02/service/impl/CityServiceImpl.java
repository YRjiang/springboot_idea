package com.example.cloudprovider02.service.impl;

import com.example.cloudapi.service.ICityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements ICityService {

    @Override
    public String get() {
        System.out.print("provider get @@@  ---  api  ---- 0202020202");
        return "provider get @@@  ---  api  ---- 0202020202";
    }

    @Override
    public String list() {
        System.out.print("provider list @@@  ---  api  ---- 0202020202");
        return "provider list @@@  ---  api  ---- 0202020202";
    }

    @Override
    public String add() {
        System.out.print("provider add @@@  ---  api  ---- 0202020202");
        return "provider add @@@  ---  api  ---- 0202020202";
    }
}
