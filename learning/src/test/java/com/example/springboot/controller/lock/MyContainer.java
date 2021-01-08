package com.example.springboot.controller.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer {

    volatile List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String [] args) {

        MyContainer c = new MyContainer();
        final Object lock = new Object();

        new Thread(()-> {
            synchronized (lock) {
                System.out.println("t2 启动");
                while (true) {
                    if (c.size() != 5) {
                        try {
                            lock.wait(); // 释放锁
                            lock.notify();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println("t2 结束");
                    }
                }
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1); // sleep 不释放锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1 启动");

            synchronized (lock) {
                System.out.println("lock 锁 ");
                for (int i = 0; i < 10; i++) {
                   c.add(new Object());
                   System.out.println("c size: " + c.size());
                   System.out.println("add " + i);
                   if (c.size() == 5) {
                       System.out.println("lock notify");
                       try {
                           lock.notify();
                           lock.wait(); // wait 会释放锁,  notify 不会释放锁
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1 结束");
            }
        }).start();

    }

}
