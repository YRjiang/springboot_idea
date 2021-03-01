package com.example.springboot.controller.threadPool;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // 自定义线程池
        /**
         *  corePoolSize:
         *  max
         */

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        for (int i = 0; i < 100; i++) {
            cachedThreadPool.execute(new MyTask(i));
        }

    }
}

class MyTask implements Runnable {

    int i = 0;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("" + Thread.currentThread() + " - " + i);
    }
}