package com.example.connect_mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.connect_mysql.mapper")
public class ConnectMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnectMysqlApplication.class, args);
    }

}
