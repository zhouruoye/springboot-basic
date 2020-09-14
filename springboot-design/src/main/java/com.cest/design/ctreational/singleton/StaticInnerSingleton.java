package com.cest.design.ctreational.singleton;

import com.cest.annotation.Safe;

/**
 * 静态内部类实现
 *
 * 当 Singleton 类被加载时，静态内部类 SingletonHolder 没有被加载进内存。
 * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE
 * 时 SingletonHolder 才会被加载，此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
 */
@Safe
public class StaticInnerSingleton {

    private static class StaticInner{
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {
    }

    public static StaticInnerSingleton getInstance(){
        return StaticInner.INSTANCE;
    }
}
