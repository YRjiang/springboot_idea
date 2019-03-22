package com.example.connect_mysql;

import com.example.connect_mysql.mapper.UserRepository;
import com.example.connect_mysql.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectMysqlApplicationTests {

    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    RedisTemplate<Object, User> userRedisTemplate;*/

    @Autowired
    RabbitTemplate rabbitTemplate;

    // rabbitMq 系统管理功能组件
    @Autowired
    AmqpAdmin amqpAdmin;

    // elasticsearch 全文搜索引擎 操作接口
//    @Autowired
//    BookStoreRepository bookStoreRepository;


    @Test
    public void contextLoads() {
        User user = userRepository.findAll().get(0);
        System.out.print("-------------" + user.toString());
    }

    /**
     * 直接操作 redis
     */
    /*@Test
    public void redisTest(){
        stringRedisTemplate.opsForValue().set("error", "this is a test!!!");
        User user = new User();
        user.setId(12);
        user.setName("大白");
        user.setPassword("xiaobai");
        userRedisTemplate.opsForValue().set("user", user);
    }*/


    @Test
    public void rabbitmqSendTest(){
        // Message 自己构造一个 自定义的消息内容 消息头
        //rabbitTemplate.send(exchage, routeKey, message);

        // 传入要发送的对象，自动序列化发送
        //rabbitTemplate.convertAndSend(exchage, routeKey, object);
        rabbitTemplate.convertAndSend("amqpAdmin.exchange", "amqpAdmin.routinKey", new User("大白", "xiaohuang"));
        System.out.print("发送完成");
    }

    @Test
    public void rabbitmqReceiveTest(){
        //Object obj = rabbitTemplate.receiveAndConvert("atguigu.news");
        //System.out.print(obj.getClass());
        //System.out.print(obj);
    }

    @Test
    public void createExchange(){
        // 创建路由
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        // 创建队列
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue", true));
        // 创建绑定
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,
                "amqpAdmin.exchange", "amqpAdmin.routinKey", null));
    }

//    @Test
//    public void elasticsearchIndex(){
//        BookStore bookStore = new BookStore();
//        bookStoreRepository.index(bookStore);
//    }
}
