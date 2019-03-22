package com.example.connect_mysql.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl {

    // 异步任务注解, 还需要 配置 @EnableAsync 在启动类中
    @Async
    public void sayHello(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("hello ----------- ");
    }

}
