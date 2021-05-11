package com.cest.linkedlist.linkedListBasic;

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
}
