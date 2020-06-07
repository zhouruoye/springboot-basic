package com.cest.threadpool.officialThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPoolTest {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Task());
        }
    }
}
