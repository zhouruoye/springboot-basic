package com.cest.util;

public class SortTest {

    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for(int n : dataSize){
            Integer[] arr = ArrayGenerator.generateRandomArray(n,n);

            SortingHelper.sortTest("SelectionSort",arr);
        }
    }
}
