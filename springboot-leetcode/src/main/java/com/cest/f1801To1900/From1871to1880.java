package com.cest.f1801To1900;

import java.util.Arrays;

public class From1871to1880 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,5,1,2,5,1,5,5,4};
        int i = minPairSum(nums);

        System.out.println(i);
    }

    /**
     * 1877. 数组中最大数对和的最小值
     * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
     * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
     *
     * nums 中每个元素 恰好 在 一个 数对中，且
     * 最大数对和 的值 最小 。
     * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
     *
     * 输入：nums = [3,5,4,2,4,6]
     * 输出：8
     * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
     * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
     *
     */
    public static int minPairSum(int[] nums) {
        int length = nums.length;
        //排序
        Arrays.sort(nums);

        if(length == 0) {
            return 0;
        }
        int i = length / 2;
        int tmp = 0;
        for (int i1 = 0; i1 <= (i - 1); i1++) {
            int res = nums[i1] + nums[length-1-i1];
            if(res > tmp) {
                tmp = res;
            }
        }
        return tmp;
    }


}
