package com.cest.basic.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;

@Slf4j
public class TestMyLock {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        for (int i = 0; i < 5; i++) {
            new Thread(myTask).start();
        }
    }
}

@Slf4j
class MyTask implements Runnable {

    Lock lock = new MyLock();

    @Override
    public void run() {
        try {
            lock.lock();
            log.info(Thread.currentThread().getName() + "获取锁");
            Thread.sleep(3000);
            log.info(Thread.currentThread().getName() + "释放锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
