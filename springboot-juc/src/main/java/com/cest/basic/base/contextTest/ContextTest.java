package com.cest.basic.base.contextTest;

/**
 * 线程上下文切换
 */
public class ContextTest {

    public static void main(String[] args) {
        // 运行多线程
        MulitTest test1 = new MulitTest();
        test1.start();

        // 运行单线程
        SerialTest test2 = new SerialTest();
        test2.start();
    }

    static class MulitTest extends ThreadContextSwitchTest {

        private final static int NUM = 4;

        @Override
        public void start() {
            long start = System.currentTimeMillis();

            Thread[] threads = new Thread[NUM];
            MyRunable myRunable = new MyRunable();

            // 创建多个线程
            for (int i = 0; i < NUM; i++) {
                threads[i] = new Thread(myRunable);
                threads[i].start();
            }

            for (int i = 0; i < NUM; i++) {
                try {
                    // 等待一起运行完
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long end = System.currentTimeMillis();
            System.out.println("multi thread exce time: " + (end - start) + "ms");
            System.out.println("counter: " + counter);
        }

        class MyRunable implements Runnable {

            @Override
            public void run() {
                while (counter < count) {
                    synchronized (this) {
                        if(counter < count) {
                            increaseCounter();
                        }

                    }
                }
            }
        }
    }

    // 创建一个单线程
    static class SerialTest extends ThreadContextSwitchTest{
        @Override
        public void start() {
            long start = System.currentTimeMillis();
            for (long i = 0; i < count; i++) {
                increaseCounter();
            }
            long end = System.currentTimeMillis();
            System.out.println("serial exec time: " + (end - start) + "ms");
            System.out.println("counter: " + counter);
        }
    }

    // 父类
    static abstract class ThreadContextSwitchTest {
        public static final int count = 100000000;

        public volatile int counter = 0;

        public int getCount() {
            return this.counter;
        }

        public void increaseCounter() {
            this.counter += 1;
        }

        public abstract void start();
    }
}
