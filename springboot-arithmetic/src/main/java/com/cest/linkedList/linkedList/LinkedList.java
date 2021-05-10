package com.cest.linkedList.linkedList;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next; //下个节点

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        size = 0;
        head = null;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        1 new 一个元素e node的next指向head node赋值给head
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        1 new node 元素直接指向head 2 将node赋值给head
        head = new Node(e, head);

        size++;
    }

    public void addLast(E e) {
        add(size,e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if (index == 0) {
           addFirst(e);
        } else {
            Node prev = head;
            //找到目标节点的前一节点
            for (int i = 0; i < (index - 1); i++) {
                prev = prev.next;
            }
            //目标节点指向后一节点 目标节点前一节点指向目标节点
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

            prev.next = new Node(e, prev.next);

        }
    }
}
