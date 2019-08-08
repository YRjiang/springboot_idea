package com.example.cloudprovider.service.impl;

import com.example.cloudapi.service.ICityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements ICityService {

    @Override
    public String get() {
        System.out.print("provider get @@@  ---  api");
        return "provider get @@@  ---  api";
    }

    @Override
    public String list() {
        System.out.print("provider list @@@  ---  api");
        return "provider list @@@  ---  api";
    }

    @Override
    public String add() {
        System.out.print("provider add @@@  ---  api");
        return "provider add @@@  ---  api";
    }
}
