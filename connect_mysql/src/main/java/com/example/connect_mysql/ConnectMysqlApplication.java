package com.example.connect_mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.connect_mysql.mapper")
@EnableCaching
@EnableRabbit    // 开启基于注解 rabbitMq 模式
@EnableAsync     // 开启异步任务
@EnableScheduling // 开启定时任务
public class ConnectMysqlApplication {

    public static void main(String[] args) {

        /**
         * Springboot 整合 Elasticsearch 在项目启动前设置一下的属性，防止报错
         * 解决netty冲突后初始化client时还会抛出异常
         * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
         */
        //System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(ConnectMysqlApplication.class, args);
    }

}
