package com.cest.basic.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * 自定义锁
 */
@Slf4j
public class MyLock implements Lock {

    LinkedBlockingQueue<Thread> queue = new LinkedBlockingQueue<Thread>();

    //0 未锁 1锁定 >1 重入锁
    volatile int state = 0;

    @Override
    public void lock() {
        while (!compareAndSwapInt(0, 1)) {
            log.info("我被锁住了" + queue.size());
            park();
        }
    }

    void park() {
        Thread thread = Thread.currentThread();
        try {
            // 将任务放到队列
            queue.put(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 让出CPU资源
        LockSupport.park();
    }

    /**
     * 如果state==0 则代表没有锁定
     * @param expect
     * @param update
     * @return
     */
    private boolean compareAndSwapInt(int expect, int update) {
        if(state == expect) {
            state = update;
            return true;
        }
        return false;
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        log.info("我要解锁了" + queue.size());
        Thread thread = queue.poll();
        log.info("我要解锁了" + thread.currentThread().getName());
        if (thread != null) {
            state = 0;
            LockSupport.unpark(thread);
        }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
