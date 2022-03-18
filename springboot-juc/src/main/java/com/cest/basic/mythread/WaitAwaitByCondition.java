package com.cest.basic.mythread;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition阻塞线程
 */
@Slf4j
public class WaitAwaitByCondition {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(() -> {
            log.info("before wait 1");

            try {
                lock.lock();

                condition.await();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }

            log.info("after wait 1");
        });

        Thread t2 = new Thread(() -> {
            log.info("before wait 2");
            try {
                lock.lock();
                condition.await();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
            log.info("after wait 2");
        });

        t1.start();
        t2.start();

        Thread.sleep(100);

        try {
            lock.lock();
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
