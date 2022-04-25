package com.cest.basic.syn;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyncTest {

    private Object object1;
    private static Object object2;

    public synchronized void test1() {

    }

    public void test2() {
        synchronized (object1) {

        }
    }

    public synchronized static void test3() {

    }

    public static void test4() {
        synchronized (object2) {

        }
    }

    public static void main(String[] args) {

    }
}
