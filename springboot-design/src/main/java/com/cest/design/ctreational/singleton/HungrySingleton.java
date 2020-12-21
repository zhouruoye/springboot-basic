package com.cest.design.ctreational.singleton;

import java.io.Serializable;

/**
 * 饿汉模式
 * Created by cestlavie on 2019/10/15.
 */
public class HungrySingleton implements Serializable{

    private HungrySingleton() {
        //防止反射
        if(hungrySingleton != null){
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    private static final HungrySingleton hungrySingleton;

    static {
        hungrySingleton = new HungrySingleton();
    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

    //防止序列化
    private Object readResolve(){
        return hungrySingleton;
    }
}
