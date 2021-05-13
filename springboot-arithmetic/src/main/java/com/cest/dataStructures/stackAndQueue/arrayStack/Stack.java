package com.cest.dataStructures.stackAndQueue.arrayStack;

public interface Stack<E> {

    //获取长度
    int getSize();

    //判断是否为空
    boolean isEmpty();

    //入栈
    void push(E e);

    //出栈
    E pop();

    //查看栈顶元素
    E peek();
}
