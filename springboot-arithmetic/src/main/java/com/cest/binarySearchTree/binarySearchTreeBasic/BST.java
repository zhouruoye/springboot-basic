package com.cest.binarySearchTree.binarySearchTreeBasic;

/**
 * 二分搜索树基础定义
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        //左右孩子
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
}
}
