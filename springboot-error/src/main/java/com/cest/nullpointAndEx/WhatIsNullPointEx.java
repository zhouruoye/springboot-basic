package com.cest.nullpointAndEx;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 什么是空指针
 */
@Slf4j
public class WhatIsNullPointEx {

    public static class User {

        private String name;
        private String[] address;
        private List<String> things;

        public void print() {
            log.info("User is a student");
        }

        public User getUserByName (String name) {
            log.info("you print name is:{}",name);
            return null;
        }

    }

    public static class UserException extends RuntimeException {

    }

    public static void main(String[] args) {
        // 1 调用了空对象的实例方法
//        User user1 = null;
//        user1.print();

        // 2 访问了空对象的属性
//        User user2 = null;
//        System.out.println(user2.name);

        // 3 当数组或集合是一个空对象的时候 取长度
        User user3 = new User();
//        System.out.println(user3.address.length);
//        System.out.println(user3.things.size());

        // 4 null值直接 throwable
//        UserException userException = null;
//        throw userException;

        // 5 方法的返回值是null
        User user5 = new User();
        System.out.println(user5.getUserByName("张三").address);
    }
}
