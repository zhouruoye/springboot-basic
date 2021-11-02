package com.cest.reflection;

import com.cest.entity.Boy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射获取的三种形式
 */
@Slf4j
public class Demo1 {

    void test() throws ClassNotFoundException {
        Boy boy = new Boy("tom", 12);

        Class aClass = boy.getClass();

        Class boyClass = Boy.class;

        Class aClass1 = Class.forName("com.cest.entity.Boy");

        System.out.println(aClass == boyClass);
        System.out.println(aClass == aClass1);

        for (int i = 0; ++i < 5; ) {
            System.out.println(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class aClass = Class.forName("com.cest.reflection.People");
        Constructor[] constructors = aClass.getConstructors();

        log.info("获取全部构造方法");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        log.info("根据类型获取构造方法");
        Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class, String.class);
        System.out.println(declaredConstructor);

        People people = (People) declaredConstructor.newInstance("123", "123");

        People o = (People) aClass.newInstance();

        Constructor declaredConstructor2 = aClass.getDeclaredConstructor(String.class);
        declaredConstructor2.setAccessible(true);

        People people2 = (People) declaredConstructor2.newInstance("123");
    }
}
