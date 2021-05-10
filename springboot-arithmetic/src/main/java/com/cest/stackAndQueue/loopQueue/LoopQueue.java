package com.cest.stackAndQueue.loopQueue;

import com.cest.stackAndQueue.arrayQueue.Queue;

/**
 * 循环队列
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int tail;
    private int front;
    private int size;

    //空间多留出1位 这样就可以定义 如果tail=front的时候 data为空 如果不留出1位 那么 tail=front 既可以为空 也可以为满 定义模糊
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        tail = 0;
        front = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public void enqueue(E e) {
        //判断是否需要扩容 定义(tail + 1) % data.length == front 为满
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        size++;
        //因为是循环队列
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        //判断是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        //front往后移一位
        E e = data[front];

        size--;
        front = (front + 1) % data.length;

        //判断是否缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return e;
    }

    @Override
    public E getFront() {
        //判断是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return data[front];
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }


    public static void main(String[] args){

        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
