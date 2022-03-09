package com.cest.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolHelper {

    private static ThreadFactory factory = r -> new Thread(r, "test-thread-pool");

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 50, 2,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),
            factory);

    public static ThreadPoolExecutor getRightThreadPool() {
        return threadPoolExecutor;
    }
}
