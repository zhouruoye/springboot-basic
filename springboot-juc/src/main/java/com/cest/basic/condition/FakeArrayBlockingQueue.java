package com.cest.basic.condition;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class FakeArrayBlockingQueue<T> {
    private int mCapacity = 3;
    private int count = 0;
    private Object[] buffer;

    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;

    private int putIndex = 0;
    private int takeIndex = 0;

    public FakeArrayBlockingQueue(int mCapacity) {
        this.mCapacity = mCapacity;
        buffer = new Object[mCapacity];
        lock = new ReentrantLock(true);
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void put(T t) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            if (count >= mCapacity) {
                log.info("队列已满,等待非满通知");
                notFull.await();
            }
            putIntoArray(t);
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            if (count <= 0) {
                log.info("队列为空，等待非空通知");
                notEmpty.await();
            }
            return takeFromArray();
        } finally {
            lock.unlock();
        }
    }

    private void putIntoArray(T t) {
        if (count >= mCapacity) {
            return;
        }
        if (++putIndex == mCapacity) {
            putIndex = 0;
        }
        buffer[putIndex] = t;
        count++;

        log.info("存入元素: " + t);
        notEmpty.signal();
    }

    private T takeFromArray() {
        if (count <= 0) {
            return null;
        }

        T t = (T) buffer[takeIndex];
        buffer[takeIndex] = null;
        if (++takeIndex == mCapacity) {
            takeIndex = 0;
        }
        count--;
        log.info("取得元素: " + t);
        notFull.signal();
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        FakeArrayBlockingQueue<Integer> blockingQueue = new FakeArrayBlockingQueue<Integer>(3);

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    blockingQueue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(500);

        new Thread(() -> {
            while (true){
                try {
                    Integer take = blockingQueue.take();
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
