package com.cest.design.ctreational.singleton;

import com.cest.status.SingletonType;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by cestlavie on 2019/10/15.
 */
@Slf4j
public class SingletonThread implements Runnable{

    private String type;

    public SingletonThread(String type) {
        this.type = type;
    }

    public SingletonThread() {
    }

    @Override
    public void run() {
        if(type.equals(SingletonType.LAZYUNSAFE)){
            LazyUnsafeSingleton lazyUnsafeSingleton = LazyUnsafeSingleton.getInstance();

            System.out.println(Thread.currentThread().getName() + " " + lazyUnsafeSingleton);
        }

        if(type.equals(SingletonType.LAZYSAFEONE)){
            LazySafeOneSingleton lazySafeOneSingleton = LazySafeOneSingleton.getInstance();

            System.out.println(Thread.currentThread().getName() + " " + lazySafeOneSingleton);
        }
    }
}
