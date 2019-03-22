package com.example.connect_mysql.service.impl;


import org.springframework.stereotype.Service;

/**
 * rabbitMq 监听服务
 */
@Service
public class RabbitMqServiceImpl {

    // 需要开启基于注解 rabbitMq 模式
    /*@RabbitListener(queues = "atguigu.news") // 队列名称
    public void receive(User user){
        System.out.print(user.toString());
    }*/

    /*@RabbitListener(queues = "atguigu")
    public void receiveMessage(Message message){
        System.out.print(message.getBody());
    }*/
}
