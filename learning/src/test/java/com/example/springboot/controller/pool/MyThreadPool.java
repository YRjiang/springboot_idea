package com.example.springboot.controller.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

    public static void main(String [] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 6; i++) {
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " ");
            });
        }

        System.out.println(service);

        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);

        // test
        // 1. 创建固定线程个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        // 2. 创建弹性缓存线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 3. 创建单线程线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // 4. 定时器线程池
    }

}
