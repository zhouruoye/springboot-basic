package com.cest.basic.mythread;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerTest {

    private static final int MAX_SIZE = 10;

    List<Integer> queue = new LinkedList<>();

    int dealData() throws InterruptedException {
        Thread.sleep((long) Math.random() * 1000);
        return (int) Math.floor(Math.random());
    }

    /**
     * 读入数据
     */
    public void readDB() throws InterruptedException {
        if(MAX_SIZE == queue.size()) {
            return;
        }

        int i = dealData();
        queue.add(i);
    }

    //Customer
    public void calculator() throws InterruptedException {
        if (queue.size() == 0) {
            return;
        }
    }
}
