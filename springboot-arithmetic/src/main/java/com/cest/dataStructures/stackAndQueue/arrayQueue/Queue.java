package com.cest.dataStructures.stackAndQueue.arrayQueue;

public interface Queue<E> {

    //获取长度
    int getSize();

    //是否为空
    boolean isEmpty();

    //入队
    void enqueue(E e);

    //出队
    E dequeue();

    //获取队首元素
    E getFront();
}
