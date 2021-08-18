package com.cest.design.ctreational.prototype.animal;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 原型模式
 */
@Slf4j
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        shallowClone();

        deepClone();
    }

    // 浅拷贝
    public static void shallowClone() throws CloneNotSupportedException {

        log.info("浅拷贝开始 -----------");

        Date birthday = new Date(0L);
        Pig pig1 = new Pig("猪八陈",birthday);
        Pig pig2 = (Pig) pig1.clone();

        System.out.println(pig1);
        System.out.println(pig2);

        pig1.getBirthday().setTime(666666666666L);
        System.out.println(pig1);
        System.out.println(pig2);

        log.info("浅拷贝结束 -----------");

    }

    // 深拷贝
    public static void deepClone() throws CloneNotSupportedException {

        log.info("深拷贝开始 -----------");

        Date birthday = new Date(0L);
        Cat cat1 = new Cat("陈猪八",birthday);
        Cat cat2 = (Cat) cat1.clone();

        System.out.println(cat1);
        System.out.println(cat2);

        cat1.getBirthday().setTime(666666666666L);
        cat1.setName("八戒");
        System.out.println(cat1);
        System.out.println(cat2);

        log.info("深拷贝结束 -----------");

    }
}
