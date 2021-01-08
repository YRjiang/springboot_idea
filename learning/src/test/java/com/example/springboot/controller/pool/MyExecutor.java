package com.example.springboot.controller.pool;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String [] args) {
        new MyExecutor().execute(()->System.out.println("hello executor"));

    }

    // callable 与 runable 区别
    // callable 可以有返回值
    // runable   没有返回值
}
