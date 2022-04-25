package com.cest.basic.base.waitNotifyTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

/**
 * wait和notify实现
 */
@Slf4j
public class WaitNotifyTest{

    public static void main(String[] args) {
        Vector<Integer> pool=new Vector<Integer>();
        Producer producer=new Producer(pool, 10);
        Consumer consumer=new Consumer(pool);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

//生产者
@Slf4j
class Producer implements Runnable {

    private int size;
    private Vector<Integer> pool;

    public Producer(Vector<Integer> vector, int size) {
        this.size = size;
        this.pool = vector;
    }

    @Override
    public void run() {
        for (;;) {
            log.info("-----开始生产消息------");
            try {
                Thread.sleep(10);
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void producer() throws InterruptedException {
        while (size == pool.size()) {
            synchronized (pool) {
                log.info("生产者开始等待消费者消费");
                pool.wait();
            }
        }

        synchronized (pool) {
            pool.add(1);
            pool.notifyAll();
        }
    }
}

//消费者
@Slf4j
class Consumer implements Runnable {

    private Vector<Integer> pool;

    public Consumer(Vector<Integer> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        for (;;) {
            log.info("-----开始消费消息------");
            try {
                Thread.sleep(5);
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consumer() throws InterruptedException {
        while (pool.size() == 0) {
            synchronized (pool) {
                log.info("消费者等待生产者进行生产");
                pool.wait();
            }
        }

        synchronized (pool) {
            pool.remove(0);
            pool.notifyAll();
        }
    }
}