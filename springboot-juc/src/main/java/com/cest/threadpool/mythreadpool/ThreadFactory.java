package com.cest.threadpool.mythreadpool;

public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
