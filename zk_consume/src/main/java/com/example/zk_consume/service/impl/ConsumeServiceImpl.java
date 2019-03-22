package com.example.zk_consume.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.zk_consume.service.IConsumeService;
import com.example.zk_consume.service.IProviderService;
import org.springframework.stereotype.Service;

@Service
public class ConsumeServiceImpl implements IConsumeService {

    @Reference
    IProviderService providerService;

    public void consume(){
        String provider = providerService.getProvider();
        System.out.print("--------" + provider);

    }
}
