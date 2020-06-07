package com.cest.threadpool.officialThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单个线程池演示
 */
public class SinglePoolThreadTest {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }
}
