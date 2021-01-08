package com.example.springboot.controller.lock;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Mycontainer03<T> {

    final private LinkedList<T> list = new LinkedList<>();
    final private int Max = 30;
    private int count = 0;

    public synchronized void put(T t) {
        while (list.size() == Max) {
            try {
                this.wait(); // wait 往往和 while 一起使用的, 线程等待，当唤醒时,
                             // 还需要再判断容器的大小, 以防其他线程执行put方法，改变容器大小
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public static void main(String [] args) {
        Mycontainer03<String> c = new Mycontainer03<>();

        // 启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();

        }
    }

}
