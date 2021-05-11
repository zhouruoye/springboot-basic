package com.cest.linkedList.dummyHeadLinkedList;

import com.cest.stackAndQueue.arrayQueue.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //从队尾入
    @Override
    public void enqueue(E e) {
        if(tail == null) {
            tail = new Node(e);
            tail = head;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size ++;
    }

    //从头部出
    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        Node removeNode = head;
        head = head.next;
        removeNode.next = null;
        if(head == null) {
            tail = null;
        }
        size --;
        return removeNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
