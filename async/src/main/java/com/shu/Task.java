package com.shu;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/*
* 配置四个任务*/
@Component
public class Task {


    private static Random random = new Random();

   /* @Async
    public void doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }*/

    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开始做任务一");
        long start = System.currentTimeMillis();
//        Thread.sleep(random.nextInt(10000));
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("doTaskOne:"+i);
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务完成");
    }

    @Async
    public Future<String> doTaskTwo() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开始做任务二");
        long start = System.currentTimeMillis();
//        Thread.sleep(random.nextInt(10000));
        Thread.sleep(100000);
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务完成");
    }

    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开始做任务三");
        long start = System.currentTimeMillis();
//        Thread.sleep(random.nextInt(10000));
        Thread.sleep(100000);
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务完成");
    }


    @Async
    public Future<People> doTaskFour() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开始做任务四");
        long start = System.currentTimeMillis();
//        Thread.sleep(random.nextInt(10000));
        Thread.sleep(100000);
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"完成任务四，耗时：" + (end - start) + "毫秒");
        People people = new People();
        people.setName("小李");
//        return new FutureImpl(people);
       return new AsyncResult<People>(people);
    }


}
