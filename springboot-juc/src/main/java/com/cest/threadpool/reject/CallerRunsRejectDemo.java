package com.cest.threadpool.reject;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 由调用线程来执行
 */
@Slf4j
public class CallerRunsRejectDemo {

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.SECONDS, queue, factory,new ThreadPoolExecutor.CallerRunsPolicy());

        while (true) {
            executor.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + queue.size());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
