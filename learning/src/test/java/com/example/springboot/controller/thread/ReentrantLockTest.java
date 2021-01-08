package com.example.springboot.controller.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock  1、可以替代 synchronized
 *                2. 比 synchronized 灵活  1.用 trylock 尝试锁定, boolean locked = lock.trylock();
 *                                         2.指定 trylock 时间
 *                                         3.lock.lockInterruptibly(); // 线程可以被 打断
 *                                         4.可以指定为 公平锁
 */
public class ReentrantLockTest extends Thread {

    private static ReentrantLock lock = new ReentrantLock(true); // 参数为true 表示: 公平锁, 等待时间长 优先

    public void run() {

        for (int i = 0; i < 30; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String [] args) {
        ReentrantLockTest rl = new ReentrantLockTest();

        Thread thread01 = new Thread(rl);
        Thread thread02 = new Thread(rl);

        thread01.start();
        thread02.start();

    }



}
