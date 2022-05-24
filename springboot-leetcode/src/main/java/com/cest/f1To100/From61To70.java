package com.cest.f1To100;

public class From61To70 {

    public static void main(String[] args) {
        int i = climbStairs1(45);
        System.out.println(i);
        //1836311903
    }

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     */
    public static int climbStairs(int n) {
        if(n < 3) {
            return n;
        }
        //使用递归
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs1(int n) {
        if(n < 3) {
            return n;
        }

        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;

        for (int i = 3; i <= n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }

        return nums[n];
    }


}
