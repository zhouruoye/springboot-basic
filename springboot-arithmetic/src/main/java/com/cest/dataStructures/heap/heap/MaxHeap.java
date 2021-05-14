package com.cest.dataStructures.heap.heap;

import com.cest.dataStructures.arrays.dynamicArray.Array;

/**
 * 最大堆 使用数组表示
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //heapify 将任意数组组成堆的形状 从最后一个非叶子节点倒着进行siftDown操作
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
            siftDown(i);
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 判断元素是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if(index == 0) {
            throw new IllegalArgumentException("index is o,doesn't have parent point");
        }

        return (index - 1)/2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return (index + 1) * 2 - 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return (index + 1) * 2;
    }

    // 向堆中添加元素 我们可以让新插入的节点与父节点对比大小。如果不满足子节点小于等于父节点的大小关系，
    // 我们就互换两个节点。一直重复这个过程，直到父子节点之间满足刚说的那种大小关系。这叫堆的上浮
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //如果i>0 并且data[i] > data[parent]
    private void siftUp(int i) {
        while(i > 0 && data.get(i).compareTo(data.get(parent(i))) > 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    //看堆中最大元素
    public E findMax() {
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }

    // 取出堆中最大元素
    // 取出首元素 将尾部元素放到首部 然后下沉 比较两个元素中最大的元素 如果比最大的元素还要大 则不继续下沉 否则和最大的元素换位置
    public E extractMax() {
        E e = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();

        siftDown(0);

        return e;
    }

    //传入索引index
    private void siftDown(int index) {
        //结束条件 k节点已经没有孩子节点了 因为左孩子索引肯定比右孩子小 所以比较右孩子即可
        while (leftChild(index) < data.getSize()) {
            //获取data[index]左右孩子里面最大的元素
            int i = leftChild(index);
            //如果存在右孩子 并且右孩子比左孩子大
            if(rightChild(index) < data.getSize() &&
                    data.get(rightChild(index)).compareTo(data.get(leftChild(index))) > 0) {
                i = rightChild(index);
            }
            //如果index 比他两个孩子中最大的一个还要大 直接结束
            if(data.get(index).compareTo(data.get(i)) > 0) {
                break;
            }

            //否则index则与其孩子中最大的互换
            data.swap(index,i);
            index = i;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e 直接将队首元素替换 然后下沉操作
    public E replace(E e) {
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }


}
