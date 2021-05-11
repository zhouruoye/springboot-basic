package com.cest.linkedlist.linkedList;

//链表
public class LinkedList<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e,Node next) {
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

    private Node nodeHeader;
    private int size;

    public LinkedList() {
        nodeHeader = new Node();
        size = 0;
    }

    //获取元素个数
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向链表中插入元素
    public void add(int index, E e) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

    }
}
