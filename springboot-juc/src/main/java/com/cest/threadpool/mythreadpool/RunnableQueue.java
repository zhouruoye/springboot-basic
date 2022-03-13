package com.cest.threadpool.mythreadpool;

/**
 * 提交任务
 */
public interface RunnableQueue {

    //提交任务
    void enqueue(Runnable runnable);

    //获取任务
    Runnable take();

    //获取任务队列的长度
    int size();
}
