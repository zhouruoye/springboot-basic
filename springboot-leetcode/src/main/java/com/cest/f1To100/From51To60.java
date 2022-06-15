package com.cest.f1To100;

import java.util.ArrayList;
import java.util.List;

public class From51To60 {

    public static void main(String[] args) {
        From51To60 from51To60 = new From51To60();
        int[] ints39 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(from51To60.maxSubArray(ints39));


    }

    /**
     * 53. 最大子数组和
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 动态规划 以2结尾的最大数是-2
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int res = Math.max(list.get(i-1) + nums[i],nums[i]);
            list.add(res);
        }
        return list.stream().max(Integer::compare).get();
    }

    /**
     * 55. 跳跃游戏
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     * 如果一个位置能够到达，那么这个位置左侧所有位置都能到达。
     */
    public boolean canJump(int[] nums) {
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if(step < i) {
                return false;
            }
            step = Math.max(step, i + nums[i]);
        }
        return true;
    }
}
