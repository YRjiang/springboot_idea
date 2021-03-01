package com.example.springboot.controller.designPattern.Flyweight;

/**
 * 享元模式的思想是：以共享的方式高效地支持大量的细粒度对象。简单来说就是共享池的思想，如连接池、线程池、字符串常量池等。
 *
 * 享元模式涉及3个角色：
 *
 * 抽象享元（Flyweight）：需要被共享的对象的抽象接口。
 * 具体享元（Concrete Flyweight）：需要被共享的实体对象。
 * 享元工厂（Flyweight Factory）：集中管理共享对象并为客户提供共享对象的工厂，也就是共享池。
 */
public class Client {

    public static void main(String[] args) {
        Pool pool = new Pool(5, "mysql", "127.0.0.1:3306", "test", "123");
        Connection conn1 = pool.getConnection();
        Connection conn2 = pool.getConnection();
        conn1.showInfo();
        conn2.showInfo();
        System.out.printf("connection rest in pool: %d\n", pool.getRestCount());
        pool.release(conn1);
        System.out.printf("connection rest in pool: %d\n", pool.getRestCount());
    }

}
