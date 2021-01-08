package com.example.springboot.controller.pool;
import	java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class MyParallelStreamApi {

    public static void main(String [] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            nums.add(1000000 + r.nextInt(1000000));
        }

        System.out.println(nums);

        long start = System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        // 使用 parallel stream api
        // parallelStream其实就是一个并行执行的流.它通过默认的ForkJoinPool,可能提高你的多线程任务的速度
        //

        start = System.currentTimeMillis();
        nums.parallelStream().forEach(MyParallelStreamApi :: isPrime);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= n/2; i++) {
            if (n % i ==0) return false;
        }
        return true;
    }

}
