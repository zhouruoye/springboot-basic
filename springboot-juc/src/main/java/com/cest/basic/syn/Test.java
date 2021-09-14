package com.cest.basic.syn;

/**
 * 并发测试
 */
public class Test {

    public static volatile int count = 0;

    public synchronized void incr() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() ->
                    new Test().incr()
            ).start();
        }

        Thread.sleep(3000);

        System.out.println(count);
    }
}
