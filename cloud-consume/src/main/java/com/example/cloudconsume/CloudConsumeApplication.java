package com.example.cloudconsume;

import com.example.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient    // 开启发现服务功能
// 启动服务时就去加载 自定义的 Ribbon 配置类, 使配置生效
@RibbonClient(name = "CLOUD-PROVIDER", configuration = MySelfRule.class)
public class CloudConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeApplication.class, args);
    }

}
