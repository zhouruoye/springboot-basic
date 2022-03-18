package com.cest.basic.mythread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitAwait {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        Thread t1 = new Thread(() -> {
            log.info("before wait 1");
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("after wait 1");
        });

        Thread t2 = new Thread(() -> {
            log.info("before wait 2");
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("after wait 2");
        });

        t1.start();
        t2.start();

        Thread.sleep(10);

        synchronized (o) {
            o.notifyAll();
        }
    }
}
