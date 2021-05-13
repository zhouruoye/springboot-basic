package com.cest.dataStructures.linkedList.dummyHeadLinkedList;

//链表 给链表添加一个虚拟头节点 这样添加元素处理不用再判断头部和其他的区别 都做同样处理
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
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
        add(0,e);
    }

    //向链表中插入元素
    public void add(int index, E e) {

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        //找到目标节点的前一位元素
        Node nodeHeader = dummyHead;

        for (int i = 0; i < index; i++) {
            nodeHeader = nodeHeader.next;
        }

        nodeHeader.next = new Node(e,nodeHeader.next);

        size ++;
    }

    public void addLast(E e) {
        add(size,e);
    }

    //找到删除前一个元素 将前一个元素指向后一个元素 当前元素下个元素指向空 然后返回空
    public E remove(int index) {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        //当前元素
        Node cur = prev.next;
        //前一个元素指向后一个元素
        prev.next = cur.next;
        //当前元素指向空
        cur.next = null;

        size --;

        return cur.e;
    }

    //删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    //删除指定元素
    public void removeElement(E e) {
        Node prev = dummyHead;
        //找到前一个元素 指向后一个元素
        while (prev.next != null) {
            if(e.equals(prev.next.e)) {
                break;
            }

            prev = prev.next;
        }

        if (prev.next != null) {
            //当前元素
            Node cur = prev.next;
            //前一个元素指向后一个元素
            prev.next = cur.next;
            //当前元素指向空
            cur.next = null;

            size --;
        }
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index) {
        if(index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的第index个位置的元素为e
    public void set(int index, E e) {
        if(index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }


        @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }


    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addLast(String.valueOf(i));
            System.out.println(linkedList.toString());
        }

        linkedList.removeElement("3");
        System.out.println(linkedList.toString());
    }
}
