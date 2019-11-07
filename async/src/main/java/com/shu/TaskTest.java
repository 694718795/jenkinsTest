package com.shu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@RestController
public class TaskTest {

    @Autowired
    Task task;

    @RequestMapping("/jenkinsTest")
    public String jenkinsTest(){
        return "jenkinsTest";
    }

    /*
    * 多个线程执行多个任务*/
    @RequestMapping("/async")
    public String async() throws Exception {
        System.out.println("进入到async");

        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
       /* Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();
        Future<People> task4 = task.doTaskFour();*/

        try {
            task1.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            boolean cancel = task1.cancel(true);
            System.out.println("task1取消");
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            boolean cancel = task1.cancel(true);
            System.out.println("task1取消");
        }

       /* while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()&& task4.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }*/

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
//        System.out.println("任务四的返回值:"+task4.get().getName());


        return "方法执行OK";
    }



}
