package com.cest.binarySearchTree.binarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;

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
        root = add(root,e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
//    public void add(Node node,E e) {
//        if(root == null) {
//            root = new Node(e);
//            size ++;
//            return;
//        }
//
//        //终止条件
//        // 1 如果插入元素等于当前节点的元素 则直接返回
//        if(e.equals(node.e)) {
//            return;
//        } //如果e < node.e 且 node的左孩子为空的时候
//        else if(e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size ++;
//            return;
//        }
//        else if(e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//
//        //递归
//        if(e.compareTo(node.e) < 0) {
//            add(node.left,e);
//        }else {
//            add(node.right,e);
//        }
//    }

    //优化
    public Node add(Node node,E e) {
        if(node == null) {
            size ++;
            //上层递归接住返回的new node
            return new Node(e);
        }

        //递归
        if(e.compareTo(node.e) < 0) {
            //node.left接住 add(node.left,e)
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }

        //==0什么都不做 将根元素返回
        return node;
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

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root,e);
    }

    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e) {

        //终止条件
        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left,e);
        } else
//        else if (e.compareTo(node.e) > 0)
        {
            return contains(node.right,e);
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    //二分搜索树的层序遍历 借用队列 首先root入队 然后出队 再左右孩子入队 然后出队 。。。。
    public void levelOrder() {
        Queue<Node> queue = new ArrayDeque<>();
        //root节点入队
        queue.add(root);

        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            System.out.println(remove.e);
            if(remove.left != null) {
                queue.add(remove.left);
            }

            if(remove.right != null) {
                queue.add(remove.right);
            }
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minimun = minimun(root);
        return minimun.e;
    }

    public Node minimun(Node node) {
        if(node.left == null) {
            return node;
        }

        return minimun(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node maximun = maximun(root);
        return maximun.e;
    }

    public Node maximun(Node node) {
        if(node.right == null) {
            return node;
        }

        return maximun(node.right);
    }

    //删除最小元素
    public E removeMin() {
        if(isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }

        E minimum = minimum();

        Node node = removeMin(root);
        return minimum;
    }

    //一直找最左元素
    public Node removeMin(Node node) {
        //如果当前节点左节点为空 那么当前节点则是最小节点 当前节点可能有右子树节点 右孩子连接到当前节点的上级节点上的左子树上
        // 返回删除节点后新的二分搜索树的根
        if(node.left == null) {
            Node right = node.right;
            node.right = null;
            size --;
            return right;
        }

        node.left = removeMin(node.left);

        return node;
    }

    //删除最大元素
    public E removeMax() {
        if(isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }

        E maximum = maximum();

        Node node = removeMax(root);

        return maximum;
    }

    public Node removeMax(Node node) {
        //终止条件
        if(node.right == null) {
            Node left = node.left;
            node.left = null;
            size --;
            return left;
        }

        node.left = removeMax(node.right);

        return node;
    }

    //删除左右都有孩子的节点d 找到节点d的后继节点 则是节点d右子树的最小节点 删除最小节点 然后替换元素d
    public void remove(E e) {
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        }

        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left,e);
            return node;
        } else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right,e);
            return node;
        } else {
            //如果左子树为空
            if(node.left == null) {
                Node right = node.right;
                node.right = null;
                size --;
                return right;
            }

            //如果右子树为空
            if(node.right == null) {
                Node left = node.left;
                node.left = null;
                size --;
                return left;
            }

            //如果都不为空的情况 找到当前节点的后继节点 既找到当前节点 用这个节点顶替待删除节点的位置
            //这里不用size--是因为removeMin里面存在size--
            Node minimun = minimun(node.right);
            minimun.right = removeMin(node.right);
            minimun.left = node.left;
            //当前目标节点左右都置空 回收
            node.right = node.left = null;

            return minimun;
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.add(5);
        bst.add(7);
        bst.add(1);
        bst.add(1);
        bst.add(1);
        bst.add(10);
        bst.add(9);

        bst.remove(2);
        System.out.println(1111);

        System.out.println(bst.contains(12));
        System.out.println("前序遍历");
        bst.preOrder();
        System.out.println("中序遍历");
        bst.inOrder();
        System.out.println("后序遍历");
        bst.postOrder();
        System.out.println("层序遍历");
        bst.levelOrder();
        System.out.println("求最大最小值");
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
    }
}
