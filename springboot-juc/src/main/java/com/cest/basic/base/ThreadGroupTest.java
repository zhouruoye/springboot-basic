package com.cest.basic.base;

public class ThreadGroupTest {

    public static void main(String[] args) {
        //获取当前threadGroup
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        //新建一个threadgroup
        ThreadGroup threadGroup1 = new ThreadGroup("threadGroup1");

        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1,"threadGroup2");

        System.out.println(threadGroup == threadGroup1.getParent());
        System.out.println(threadGroup1 == threadGroup2.getParent());
    }
}
