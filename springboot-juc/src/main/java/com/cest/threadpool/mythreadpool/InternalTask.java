package com.cest.threadpool.mythreadpool;

public class InternalTask implements Runnable{

    private final RunnableQueue runnableQueue;
    private volatile boolean running =true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        //线程没有中断，则不断从队列中取出Runnable,执行run方法
        while(running && !Thread.currentThread().isInterrupted() ) {
            Runnable task = runnableQueue.take();
            task.run();
        }
    }

    //停止当前任务
    public void stop() {
        this.running = false;
    }
}
