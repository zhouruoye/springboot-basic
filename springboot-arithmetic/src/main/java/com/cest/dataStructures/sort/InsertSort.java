package com.cest.dataStructures.sort;

/**
 * O(n^2)
 * 直接插入排序
 * 直接插入排序(Straight Insertion Sort)的基本思想是：把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含1个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
 * 例子 玩扑克 抓牌
 */
public class InsertSort {

    public static void sortMin(int[] insert) {
        int length = insert.length;
        //从1开始 第0个默认为已经排好序
        for (int i = 1; i < length; i++) {
            //当前取出的元素
            int A = insert[i];
            //从0到i开始排序
            int tmp = -1;
            int swap = 0;
            for(int j = 0; j < i+1; j++) {
                if(insert[j] >= A && tmp == -1) {
                    swap = insert[j];
                    insert[j] = A;
                    tmp = 1;
                } else if(tmp != -1) {
                    //向后移动一位
                    int i1 = insert[j];
                    insert[j] = swap;
                    swap = i1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,3,4,6,5,2};
        InsertSort.sortMin(arr);
        for (int e:arr
        ) {
            System.out.print(e+"  ");
        }
        System.out.println();
    }
}
