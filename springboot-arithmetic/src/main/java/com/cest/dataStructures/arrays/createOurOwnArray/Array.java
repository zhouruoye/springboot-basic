package com.cest.dataStructures.arrays.createOurOwnArray;

public class Array {

    private int[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //添加最后一个元素
    public void addLast(int e) {
        add(size, e);
    }

    //添加到第一个元素
    public void addFirst(int e) {
        add(0, e);
    }


    // 获取index索引位置的元素
    public int get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        //在 index后的数组都要向后面移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;

        size++;
    }

    // 查找数组中是否有元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public int remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        int target = data[index];
        //从index到size-1的往前移
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return target;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public int removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public int removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(int e) {
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

}
