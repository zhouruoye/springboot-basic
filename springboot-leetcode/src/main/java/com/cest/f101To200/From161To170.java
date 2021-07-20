package com.cest.f101To200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class From161To170 {

    public static void main(String[] args) {
        int[] arr = new int[]{};
        findMissingRanges(arr,1,1);
    }

    /**
     * 163. 缺失的区间
     * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
     * 示例：
     * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
     * 输出: ["2", "4->49", "51->74", "76->99"]
     */
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<Integer> collect = null;
        if(nums.length == 0) {
            collect = new ArrayList<>();
        } else {
            collect = Arrays.stream(nums).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }

        if(collect.size() == 0 || collect.get(0) != lower) {
            collect.add(0,lower-1);
        }

        if(collect.get(collect.size() - 1) != upper) {
            collect.add(collect.size(),upper+1);
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < collect.size()-1; i++) {
            if(collect.get(i) == collect.get(i+1) || collect.get(i) + 1 == collect.get(i+1)) {
                continue;
            } else if(collect.get(i) + 2 == collect.get(i+1)) {
                res.add(String.valueOf(collect.get(i) + 1));
            } else {
                res.add((collect.get(i) + 1) + "->" + (collect.get(i + 1) - 1));
            }
        }

        return res;
    }


}
