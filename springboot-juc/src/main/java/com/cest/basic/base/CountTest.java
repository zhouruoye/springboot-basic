package com.cest.basic.base;

/**
 * 多线程读取缓存导致数据不一致
 */
public class CountTest {

    private volatile int count = 0;

    private void addLargeNumber() {
        int idx = 0;
        while(idx++ < 1000000) {
            synchronized (this) {
                count ++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountTest test = new CountTest();
        Thread thread1 = new Thread(() -> {
            test.addLargeNumber();
        });

        Thread thread2 = new Thread(() -> {
            test.addLargeNumber();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(test.count);
    }
}
