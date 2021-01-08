package com.example.springboot.controller.lock;
import	java.util.concurrent.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer02 {

    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String [] args) {
        MyContainer02 c = new MyContainer02();

        CountDownLatch latch = new CountDownLatch(1); // 门栓 门栓数：1

        new Thread(()->{
            System.out.println("t2 启动");
            if (c.size() != 5) {
                try {
                    latch.await(); // 门栓上锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);
                if (c.size() == 5) {
                    latch.countDown(); // 门栓数减 1, 本线程继续; 门栓为 0, 门栓解锁
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }

}
