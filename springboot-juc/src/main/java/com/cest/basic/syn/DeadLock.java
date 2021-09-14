package com.cest.basic.syn;

/**
 * 互斥，共享资源 X 和 Y 只能被一个线程占用；
 * 占有且等待，线程 T1 已经取得共享资源 X，在等待共享资源 Y 的时候，不释放共享资源 X；
 * 不可抢占，其他线程不能强行抢占线程 T1 占有的资源；
 * 循环等待，线程 T1 等待线程 T2 占有的资源，线程 T2 等待线程 T1 占有的资源，就是循环等待。
 */
public class DeadLock {

    public static Object object1 = new Object();
    public static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(new LockA()).start();
        new Thread(new LockB()).start();
    }
}

class LockA implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("执行方法A");
            synchronized (DeadLock.object1) {
                System.out.println("锁定object1");
                Thread.sleep(1000);
                synchronized (DeadLock.object2) {
                    System.out.println("锁定object2");
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("LockA解锁");
    }
}


class LockB implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("执行方法B");
            synchronized (DeadLock.object2) {
                System.out.println("锁定object2");
                Thread.sleep(1000);
                synchronized (DeadLock.object1) {
                    System.out.println("锁定object1");
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("LockB解锁");
    }
}

