package com.example.springboot.controller.concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;

public class ConcurrentMap {

    public static void main(String [] args) {
        Map<String, String> map = new ConcurrentHashMap<>(); // 并发性不高，要带锁 使用这个
        //Map<String, String> map = new ConcurrentSkipListMap<>(); // 高并发 且 排序, 插入耗时久(主要因为排序)

        //Map<String, String> map = new Hashtable<>(); // 已经加锁了
        //Map<String, String> map = new HashMap<>(); // Collections.synchronizedXXX  利用这个 加锁
        // TreeMap // 排序

        Random random = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put("a " + random.nextInt(10000), "a " + random.nextInt(10000));
                    latch.countDown();
                }
            });
        }

        Arrays.asList(threads).forEach(t->t.start());

        try {
            latch.await();
        } catch (Exception e ) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("消耗时间: " + (end - start) + " 毫秒");


        // 未加锁的list 调用 Collections.synchronizedList 方法, 返回 加锁的 list
        ArrayList<Object> list = new ArrayList<>();
        List<Object> synchronizedList = Collections.synchronizedList(list);

        /**
         * 一个基于链接节点的无界线程安全队列。此队列按照 FIFO（先进先出）原则对元素进行排序。
         * 队列的头部 是队列中时间最长的元素。队列的尾部 是队列中时间最短的元素。
         *
         * 新的元素插入到队列的尾部，队列获取操作从队列头部获得元素。
         * 当多个线程共享访问一个公共 collection 时，ConcurrentLinkedQueue 是一个恰当的选择。此队列不允许使用 null 元素。
         */
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        queue.offer("哈哈哈");
        System.out.println("offer后，队列是否空？" + queue.isEmpty());
        System.out.println("从队列中poll：" + queue.poll());
        System.out.println("pool后，队列是否空？" + queue.isEmpty());


    }

}
