package com.cest.design.ctreational.singleton;

import com.cest.status.SingletonType;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * Created by cestlavie on 2019/10/15.
 */
@Slf4j
public class SingletonTest {

    public static void main(String[] args) throws Exception {
        //lazyUnsafe();
        //lasySafeOne();
        //serializable2Singleton();
        enumSingleton();


    }

    public static void enumSingleton(){

        EnumInstance instance = EnumInstance.getInstance();
        instance.setData(new Object());
        Object data = instance.getData();
        System.out.println(data);
        instance.setData(new Object());
        Object data1 = instance.getData();
        System.out.println(data1);

        instance.test();
    }

    /**
     * 序列化对单例的影响
     */
    public static void serializable2Singleton() throws Exception {
        HungrySingleton instance = HungrySingleton.getInstance();
        log.info("序列化前的单例对象:{}",instance);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("singleton_file")));
        HungrySingleton hungrySingleton = (HungrySingleton) ois.readObject();
        log.info("序列化后的单例对象:{}",hungrySingleton);

    }


    public static void lazyUnsafe(){
        Thread thread1 = new Thread(new SingletonThread(SingletonType.LAZYUNSAFE));
        Thread thread2 = new Thread(new SingletonThread(SingletonType.LAZYUNSAFE));
        thread1.start();
        thread2.start();

        log.info("--------------------- end -------------------");
    }

    public static void lasySafeOne(){
        Thread thread1 = new Thread(new SingletonThread(SingletonType.LAZYSAFEONE));
        Thread thread2 = new Thread(new SingletonThread(SingletonType.LAZYSAFEONE));
        thread1.start();
        thread2.start();

        log.info("--------------------- end -------------------");
    }
}
