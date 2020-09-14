package com.cest.design.ctreational.singleton;

import com.cest.annotation.Safe;

/**
 * 3 对 LazySafeOneSingleton 优化
 *  双重校验锁-线程安全
 *
 *  说明: 指令重排   lazyUnsafeSingleton = new LazySafeTwoSingleton();
 *  实例化 lazyUnsafeSingleton 一共发生的三件事
 *  1 为 lazyUnsafeSingleton 分配内存空间
 *  2 初始化 lazyUnsafeSingleton
 *  3 将 lazyUnsafeSingleton 指向分配的内存地址
 *
 *  但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。
 *  指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。
 *  例如，线程 T1 执行了 1 和 3，此时 T2 调用 getInstance() 后发现 lazyUnsafeSingleton 不为空，
 *  因此返回 lazyUnsafeSingleton，但此时 lazyUnsafeSingleton 还未被初始化。
 *
 *  使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
 */
@Safe
public class LazySafeTwoSingleton {

    private volatile static LazySafeTwoSingleton lazyUnsafeSingleton = null;

    public static LazySafeTwoSingleton getInstance(){
        if(lazyUnsafeSingleton == null){
            synchronized (LazySafeTwoSingleton.class){
                if(lazyUnsafeSingleton == null){
                    lazyUnsafeSingleton = new LazySafeTwoSingleton();
                }
            }
        }
        return lazyUnsafeSingleton;
    }

    private LazySafeTwoSingleton() {

    }
}
