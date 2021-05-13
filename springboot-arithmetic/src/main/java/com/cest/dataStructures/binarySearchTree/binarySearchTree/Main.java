package com.cest.dataStructures.binarySearchTree.binarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000000));
        }

        List<Integer> list = new ArrayList<>();

        while (!bst.isEmpty()) {
            //删除最小元素
            Integer integer = bst.removeMin();
            list.add(integer);
        }

        System.out.println("size: " + list.size());

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1) > list.get(i)) {
                throw new IllegalArgumentException("error");
            }
        }
        long endTime = System.nanoTime();

        System.out.println("bsn foreach complete,Time is " + (endTime - startTime)/(1000 * 1000) + "ms" );
    }
}
