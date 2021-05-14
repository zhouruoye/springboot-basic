package com.cest.dataStructures.heap.heap;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 100000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = maxHeap.extractMax();
        }

        for(int i = 1 ; i < n ; i ++) {
            if(nums[i-1] < nums[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("Test MaxHeap completed.");

    }
}
