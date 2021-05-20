package com.cest.f1201to1300;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class From1211to1220 {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,4,5};
        int[] num2 = new int[]{1,2,5,7,9};
        int[] num3 = new int[]{1,3,4,5,8};
        List<Integer> list = arraysIntersection(num1, num2, num3);
        System.out.println(1);
    }

    /**
     * 1213. 三个有序数组的交集
     * 给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。
     * 返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。
     * 示例：
     * 输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
     * 输出: [1,5]
     * 解释: 只有 1 和 5 同时在这三个数组中出现.
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        List<Integer> list3 = Arrays.stream(arr3).boxed().collect(Collectors.toList());

        List<Integer> collect1 = list1.stream().filter(n -> list3.contains(n)).collect(Collectors.toList());
        List<Integer> collect2 = list2.stream().filter(n -> list3.contains(n)).collect(Collectors.toList());
        return collect1.stream().filter(n -> collect2.contains(n)).collect(Collectors.toList());
    }
}
