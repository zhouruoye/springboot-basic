package com.cest.design.ctreational.singleton;

/**
 * 线程单例 在某一个线程之中为单例模式
 * Created by cestlavie on 2019/10/16.
 */
public class ThreadLocalInstance {

    private static final ThreadLocal<ThreadLocalInstance> t
            = new ThreadLocal<ThreadLocalInstance>(){
        @Override
        protected ThreadLocalInstance initialValue() {
            return new ThreadLocalInstance();
        }
    };

    public static ThreadLocalInstance getInstance(){
        return t.get();
    }

    private ThreadLocalInstance(){

    }
}
