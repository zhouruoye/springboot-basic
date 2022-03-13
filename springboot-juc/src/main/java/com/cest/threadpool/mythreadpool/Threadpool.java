package com.cest.threadpool.mythreadpool;

/**
 * 自定义线程池接口
 */
public interface Threadpool {

    //提交任务到线程池
    void execute(Runnable runnable);

    //关闭线程池
    void shutDown();

    //获取线程池初始化大小
    int getInitSize();

    //获取线程池最大线程数
    int getMaxSize();

    //获取核心线程池数量
    int getCoreSize();

    //获取线程池的队列缓存大小
    int getQueueSize();

    //获取线程池中活跃的线程数量
    int getActiveCount();

    //查看线程池是否已经被关闭
    boolean isShutdown();
}
