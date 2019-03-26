package com.example.cloudprovider.service.impl;

import com.example.cloudapi.service.ICityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements ICityService {

    @Override
    public String get() {
        return "provider get @@@";
    }

    @Override
    public String list() {
        return "provider list @@@";
    }

    @Override
    public String add() {
        return "provider add @@@";
    }
}
