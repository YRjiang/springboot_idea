package com.example.springboot.controller.sigleton;

import java.util.Arrays;

/**
 * 线程安全的单例模式
 * 静态内部类形式
 *
 */
public class Singleton02 {

    private Singleton02() {
        System.out.println("single");
    }

    private static class Inner {
        private static Singleton02 s = new Singleton02();
    }


    public static Singleton02 getSingleton() {
        return Inner.s;
    }

    public static void main(String [] args) {
        Thread[] threads = new Thread[200];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                Singleton02.getSingleton();
            });
        }
        Arrays.asList(threads).forEach(o->o.start());
    }

}
