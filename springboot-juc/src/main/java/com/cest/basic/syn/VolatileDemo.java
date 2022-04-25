package com.cest.basic.syn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {

    public static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stop) {
                i ++;
            }
            System.out.println("result:" + i);
        });

        thread.start();

        Thread.sleep(1000);
        stop = true;
    }
}
