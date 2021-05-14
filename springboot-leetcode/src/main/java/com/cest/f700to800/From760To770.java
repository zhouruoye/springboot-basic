package com.cest.f700to800;

import java.util.HashMap;
import java.util.Map;

public class From760To770 {

    public static void main(String[] args) {
        anagramMappings(new int[]{12, 28, 46, 32, 50},new int[]{50, 12, 32, 46, 28});
    }

    /**
     * 760. 找出变位映射
     * 给定两个列表 Aand B，并且 B 是 A 的变位（即 B 是由 A 中的元素随机排列后组成的新列表）。
     * 我们希望找出一个从 A 到 B 的索引映射 P 。一个映射 P[i] = j 指的是列表 A 中的第 i 个元素出现于列表 B 中的第 j 个元素上。
     * 列表 A 和 B 可能出现重复元素。如果有多于一种答案，输出任意一种。
     A = [12, 28, 46, 32, 50]
     B = [50, 12, 32, 46, 28]
     需要返回
     [1, 4, 3, 2, 0]
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],i);
        }

        int[] newIndex = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            newIndex[i] = map.get(nums1[i]);
        }

        return newIndex;
    }
}
