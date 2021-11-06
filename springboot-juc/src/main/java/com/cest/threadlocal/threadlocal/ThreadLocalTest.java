package com.cest.threadlocal.threadlocal;

/**
 * ThreadLocal 隔离性
 */
public class ThreadLocalTest {

    static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                int now = local.get();
                local.set(now + 5);
                System.out.println(Thread.currentThread().getName() + "-" + now);
            });
        }

        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
    }
}
