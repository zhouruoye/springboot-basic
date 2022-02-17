package com.cest.basic.base;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class JoinTest implements Runnable{

    private String name;

    public JoinTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        log.info("start by: {}",name);

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("end by: {}",name);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new JoinTest("T1"));
        Thread t2 = new Thread(new JoinTest("T2"));
        Thread t3 = new Thread(new JoinTest("T3"));

        try {
            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
