package com.cest.reflection;

import com.cest.entity.Boy;

/**
 * 反射获取的三种形式
 */
public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException {

        Boy boy = new Boy("tom",12);

        Class aClass = boy.getClass();

        Class boyClass = Boy.class;

        Class aClass1 = Class.forName("com.cest.entity.Boy");

        System.out.println(aClass == boyClass);
        System.out.println(aClass == aClass1);

        for (int i = 0; ++i < 5;) {
            System.out.println(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}
