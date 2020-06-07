package com.cest.threadpool.OOM;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示OOM异常 内存越大 异常时间越长
 */
@Slf4j
public class FixedPoolThreadWithOOMTest {

    public static final int THREAD_NUM = 1;

    public static void main(String[] args) {
        log.info("建立固定个数为" + THREAD_NUM + "的线程");
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        log.info("开始执行线程");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executorService.execute(new TaskOOM());
        }
    }
}

/**
 * 线程任务
 */
@Slf4j
class TaskOOM implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info(Thread.currentThread().getName());
        }
    }
}
