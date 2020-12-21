package com.cest.design.ctreational.singleton;

import com.cest.annotation.UnSafe;

/**
 * 1 单例模式要素  私有构造方法
 * 这个实现在多线程环境下是不安全的，如果多个线程能够同时进入 if (lazyUnsafeSingleton == null) ，
 * 并且此时 lazyUnsafeSingleton 为 null，那么会有多个线程执行 lazyUnsafeSingleton = new LazyUnsafeSingleton();
 * 语句，这将导致实例化多次 lazyUnsafeSingleton。
 */
@UnSafe
public class LazyUnsafeSingleton {

    private static LazyUnsafeSingleton lazyUnsafeSingleton = null;

    public static LazyUnsafeSingleton getInstance(){
        if(lazyUnsafeSingleton == null){
            lazyUnsafeSingleton = new LazyUnsafeSingleton();
        }
        return lazyUnsafeSingleton;
    }

    private LazyUnsafeSingleton() {
    }
}
