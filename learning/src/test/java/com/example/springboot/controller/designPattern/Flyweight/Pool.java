package com.example.springboot.controller.designPattern.Flyweight;

import java.util.Stack;

public class Pool {

    private Stack<Connection> stack = new Stack<>();
    private Connection sample; // 保存一个连接样本作参照
    private int size; // 连接池大小

    // 初始化连接池
    public Pool(int size, String driver, String url, String user, String password) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            Connection conn = new ConcreteConnection(driver, url, user, password);
            stack.push(conn);
        }
        this.sample = stack.peek();
    }

    // 从连接池中获取一个连接
    public Connection getConnection() {
        return stack.isEmpty() ? null : stack.pop();
    }

    // 归还一个连接给连接池
    public void release(Connection conn) {
        if (stack.size() == size) // 超过连接池大小
            throw new RuntimeException("pool is full!");
        if (!conn.equals(this.sample)) // 要归还的连接与池中的连接不一样
            throw new RuntimeException("this conn is not a Flyweight");
        stack.push(conn);
    }

    // 获取连接池中剩余连接的数量
    public int getRestCount() {
        return stack.size();
    }

    // Getters and Setters
    // 这里，作为实际实现功能的集合不对外公开
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
