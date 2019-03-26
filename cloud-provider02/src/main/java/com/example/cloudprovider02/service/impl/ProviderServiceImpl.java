package com.example.cloudprovider02.service.impl;

import com.example.cloudprovider02.service.IProviderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProviderServiceImpl implements IProviderService {
    @Override
    public String getProvider() {
        System.out.print("厉害了！！！第二个 cloud provider port 8002 ");
        return "cloud provider port 8002 : " + LocalDate.now().toString();
    }
}
