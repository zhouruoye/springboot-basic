package com.cest.binarySearchTree.binarySearchTree;

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

    //向二分搜索树添加元素
    public void add(E e) {
        add(root,e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    public void add(Node node,E e) {
        if(root == null) {
            root = new Node(e);
            size ++;
            return;
        }

        //终止条件
        // 1 如果插入元素等于当前节点的元素 则直接返回
        if(e.equals(node.e)) {
            return;
        } //如果e < node.e 且 node的左孩子为空的时候
        else if(e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size ++;
            return;
        }
        else if(e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size ++;
            return;
        }

        //递归
        if(e.compareTo(node.e) < 0) {
            add(node.left,e);
        }else {
            add(node.right,e);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
}



    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }


    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        for (int i = 0; i < 10; i++) {
            bst.add(i);
        }

        System.out.println(bst.toString());
        System.out.println(1111);
    }
}
