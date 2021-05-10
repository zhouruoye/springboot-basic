package com.cest.linkedList.linkedListBasic;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next; //下个节点

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
