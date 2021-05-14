package com.cest.dataStructures.sort;

/**
 * O(n^2)
 * 冒泡排序(Bubble Sort)，又被称为气泡排序或泡沫排序。
 * 它是一种较简单的排序算法。它会遍历若干次要排序的数列，每次遍历时，它都会从前往后依次的比较相邻两个数的大小；如果前者比后者大，则交换它们的位置。
 * 这样，一次遍历之后，最大的元素就在数列的末尾！ 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！
 */
public class BubbleSort {

    //将最大的放到后面
    public static void sortMax(int[] bubble) {
        int length = bubble.length;
        for (int i = length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(bubble[j] > bubble[j+1]) {
                    int tmp = bubble[j];
                    bubble[j] = bubble[j+1];
                    bubble[j+1] = tmp;
                }
            }
        }
    }

    //将最小的放到后面
    public static void sortMin(int[] bubble) {
        int length = bubble.length;
        for (int i = length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(bubble[j] < bubble[j+1]) {
                    int tmp = bubble[j];
                    bubble[j] = bubble[j+1];
                    bubble[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] a = {20,40,30,10,60,50};
//        sortMin(a);
//        System.out.println(a.toString());

        String type = "01,02,03";

        int i = type.indexOf("011");
        int i1 = type.indexOf("02");
        int i2 = type.indexOf("03");
        System.out.println(111);
    }
}
