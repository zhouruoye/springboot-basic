package com.cest.basic.mythread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRunnableTest implements Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("hahha");
            try {
                log.info("sleeping");
                Thread.sleep(100000);
                log.info("sleep over");
            } catch (InterruptedException e) {
                log.info("InterruptedException");
                e.printStackTrace();
            }
        });
        t.start();
        t.interrupt();
    }

    @Override
    public void run() {
        log.info("MyRunnableTest test");
    }
}
