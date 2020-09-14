package com.cest.design.ctreational.singleton;

import com.cest.annotation.Safe;

/**
 * 2 只需要对 getInstance() 方法加锁 那么在一个时间点只能有一个线程能够进入该方法，
 *   从而避免了实例化多次 lazyUnsafeSingleton。
 *   在静态方法上加锁相当于加在类上
 *
 *   缺点 但是当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，
 *   即使 lazyUnsafeSingleton 已经被实例化了。这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用。
 */
@Safe
public class LazySafeOneSingleton {

    private static LazySafeOneSingleton lazyUnsafeSingleton = null;

    //    1 第一种加锁方法
    //public static synchronized LazySafeSingleton getInstance(){
    //    if(lazyUnsafeSingleton == null){
    //        lazyUnsafeSingleton = new LazySafeSingleton();
    //    }
    //    return lazyUnsafeSingleton;
    //}

    // 2 第二种加锁方法
    public static  LazySafeOneSingleton getInstance(){
        synchronized (LazySafeOneSingleton.class){
            if(lazyUnsafeSingleton == null){
                lazyUnsafeSingleton = new LazySafeOneSingleton();
            }
            return lazyUnsafeSingleton;
        }
    }

    private LazySafeOneSingleton() {
    }
}
