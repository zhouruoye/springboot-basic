package com.cest.basic.mythread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThread extends Thread{
    @Override
    public void run() {
      log.info("mythread test");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

