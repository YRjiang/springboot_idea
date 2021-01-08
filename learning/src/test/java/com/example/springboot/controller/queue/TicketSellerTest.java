package com.example.springboot.controller.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketSellerTest {

    // 并发容器 链表队列
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("售票 编号 " + i);
        }
    }

    public static void main(String [] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true) {
                    String s = tickets.poll();
                    if (s == null) {
                        System.out.println("票 已经售空...");
                        break;
                    } else {
                        System.out.println("销售了--- " + s);
                    }
                }
            }).start();
        }
    }


}
