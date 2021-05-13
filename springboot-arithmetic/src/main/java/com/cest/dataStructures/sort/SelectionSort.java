package com.cest.dataStructures.sort;

/**
 * 选择排序
 * 先把最小的拿出来，在剩下的里面再把最小的拿出来…
 * 这个过程一直持续，每次选择还没处理的元素里最小的元素
 */
public class SelectionSort {

    private SelectionSort() {
    }

    //extends 使用在泛型表示实现了Comparable接口
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int tmp = i; //取第一个的索引 然后与后面进行比较
            for (int j = i; j < arr.length; j++) {
                //取最小的
                if(arr[j].compareTo(arr[tmp]) < 0) {
                    tmp = j;
                }
            }

            //进行交换
            swap(arr,i,tmp);
        }
    }

    private static <E>void swap(E[] arr,int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

        Integer[] arr={1,3,4,6,5,2};
        SelectionSort.sort(arr);
        for (int e:arr
        ) {
            System.out.print(e+"  ");
        }
        System.out.println();
    }

}
