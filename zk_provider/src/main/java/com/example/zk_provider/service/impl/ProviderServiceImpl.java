package com.example.zk_provider.service.impl;

import com.example.zk_provider.service.IProviderService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * 1. 将服务提供者注册到注册中心 zookeeper
 *    1. 引入 dubbo  、 zkclient 相关依赖
 *    2. 配置 dubbo 扫描包 和 注册中心地址
 *    3. 使用 dubbo 的 @Service 注解 发布服务
 */

@Component
@Service    // 将服务发布到 zookeeper
public class ProviderServiceImpl implements IProviderService {
    @Override
    public String getProvider() {
        System.out.print("厉害了！！！");
        return "success";
    }
}
