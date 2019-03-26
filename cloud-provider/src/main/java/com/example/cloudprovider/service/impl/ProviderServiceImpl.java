package com.example.cloudprovider.service.impl;

import com.example.cloudprovider.service.IProviderService;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements IProviderService {
    @Override
    public String getProvider() {
        System.out.print("厉害了！！！第二个 cloud provider port 8001 ");
        return "cloud provider port 8001 : ";
    }
}
