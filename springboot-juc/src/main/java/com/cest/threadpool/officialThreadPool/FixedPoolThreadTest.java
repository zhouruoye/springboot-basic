package com.cest.threadpool.officialThreadPool;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程
 */
@Slf4j
public class FixedPoolThreadTest {

    public static final int THREAD_NUM = 5;

    public static void main(String[] args) {
        log.info("建立固定个数为" + THREAD_NUM + "的线程");
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        log.info("开始执行线程");

        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }
}

/**
 * 线程任务
 */
@Slf4j
class Task implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info(Thread.currentThread().getName());
        }
    }
}
