package com.cest.dataStructures.linkedList.linkedList;

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
        nodeHeader = null;
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

    //添加第一个
    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = nodeHeader;
        nodeHeader = node;
        size ++;
    }

    //向链表中插入元素
    public void add(int index, E e) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        if(index == 0) {
            addFirst(e);
        }else {
            //找到目标节点的前一位元素
            Node nodeHeader = this.nodeHeader;

            for (int i = 0; i < (index - 1); i++) {
                nodeHeader = nodeHeader.next;
            }

//            Node cur = new Node(e);
//            cur.next = nodeHeader.next;
//            nodeHeader.next = cur;

            nodeHeader.next = new Node(e,nodeHeader.next);
        }

        size ++;
    }

    public void addLast(E e) {
        add(size,e);
    }
}
