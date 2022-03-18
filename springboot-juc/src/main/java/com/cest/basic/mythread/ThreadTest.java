package com.cest.basic.mythread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {

    private static final int taskSize = 10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(taskSize);
        
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            int a = i;
            Callable<Integer> callable = () -> {
              return a * a;
            };
            Future<Integer> submit = executorService.submit(callable);
            futureList.add(submit);
        }

                // 关闭线程池
        executorService.shutdown();
        // 获取所有并发任务的运行结果
        for (Future f : futureList) {
        // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("res：" + f.get().toString());
        }
        

//        //创建一个线程池
//        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
//        // 创建多个有返回值的任务
//        List<Future> list = new ArrayList<Future>();
//        for (int i = 0; i < taskSize; i++) {
//            Callable c = new MyCallable(i + " ");
//            // 执行任务并获取 Future 对象
//            Future f = pool.submit(c);
//            list.add(f);
//        }
//        // 关闭线程池
//        pool.shutdown();
//        // 获取所有并发任务的运行结果
//        for (Future f : list) {
//        // 从 Future 对象上获取任务的返回值，并输出到控制台
//            System.out.println("res：" + f.get().toString());
//        }
    }
}
