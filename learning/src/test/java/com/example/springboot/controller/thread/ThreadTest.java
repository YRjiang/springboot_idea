package com.example.springboot.controller.thread;

public class ThreadTest {

    public synchronized void n1() {
        System.out.println(Thread.currentThread().getName() + " n1 start...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " n1 end...");
    }

    public void n2() {
        System.out.println(Thread.currentThread().getName() + " n2 start...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " n2 end...");
    }

    public static void main(String [] args) {
        ThreadTest t = new ThreadTest();
        /*new Thread(()->t.n1(), "t1").start();
        new Thread(()->t.n2(), "t2").start();*/

        new Thread(t::n1).start();
        new Thread(t::n2).start();

    }

}
