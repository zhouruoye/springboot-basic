package com.cest.f1001to1100;

public class From1081To1090 {

    public static void main(String[] args) {
        int[] nums = new int[]{34,23,1,24,75,33,54,8};
        sumOfDigits(nums);
    }

    /**
     * 1085. 最小元素各数位之和
     * 给你一个正整数的数组 A。
     * 然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
     * 最后，假如 S 所得计算结果是 奇数 ，返回 0 ；否则请返回 1。
     * 输入：[34,23,1,24,75,33,54,8]
     * 输出：0
     * 解释：
     * 最小元素为 1 ，该元素各个数位上的数字之和 S = 1 ，是奇数所以答案为 0 。
     * @param nums
     * @return
     */
    public static int sumOfDigits(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
            }
        }

        int length = String.valueOf(min).length();

        int count = 0;

        for (int i = 0; i < length; i++) {
            count += min % 10;
            min = min/10;
        }
        return count % 2 == 0 ? 1 : 0;
    }
}
