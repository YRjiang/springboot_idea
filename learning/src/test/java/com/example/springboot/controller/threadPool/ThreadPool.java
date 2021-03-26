package com.example.springboot.controller.threadPool;

import java.util.concurrent.*;

public class ThreadPool {

    /**
     *  线程优先级
     *  提交优先级
     *  执行优先级
     *
     */

    /**
     *
     *              execute                 addWorker                 runWork            getTask                processWorkerExit
     *  1. 提交任务     |      2. 创建Work对象      |    3. 启动Work对象     |     4. 获取任务    |      5. 启动自行任务        |
     *                |                          |                       |                  |                           |
     *                                           |   ---------------------------6. 增加任务 ---------------------------   |
     */


    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // 自定义线程池
        /**
         *  corePoolSize:       核心线程数
         *  maximumPoolSize:    最大线程数
         *  keepAliveTime:      线程空闲时间
         *  unit:               keepAliveTime 的时间单位
         *  workQueue:          缓存队列
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));

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
        System.out.println("" + Thread.currentThread().getName() + " - " + i);
    }
}