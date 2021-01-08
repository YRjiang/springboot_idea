package com.example.springboot.controller.pool;

import java.util.concurrent.*;

public class MyFuture {
    public static void main(String [] args) throws InterruptedException, Exception {
         FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

         new Thread(task).start();

         System.out.println(task.get());

         //*********************************
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> task1 = service.submit (()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });

        System.out.println(task1.get());
        System.out.println(task1.isDone());

    }
}
