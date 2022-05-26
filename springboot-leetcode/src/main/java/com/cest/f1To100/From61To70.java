package com.cest.f1To100;

public class From61To70 {

    public static void main(String[] args) {
//        int i = climbStairs2(45);

        uniquePaths(3, 2);
        System.out.println(111);
        //1836311903
    }


    /**
     * 62. 不同路径
     * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * 示例 2：
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     *
     * 动态规划
     * pathTimes[i][j] = pathTimes[i][j-1] + pathTimes[i-1][j]
     */
    public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) {
            return 1;
        }

        int[][] pathTimes = new int[m][n];

        for (int i = 0; i < m; i++) {
            pathTimes[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            pathTimes[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathTimes[i][j] = pathTimes[i][j-1] + pathTimes[i-1][j];
            }
        }

        return pathTimes[m-1][n-1];
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

    /**
     * 空间 时间复杂度都是O（n）
     * @param n
     * @return
     */
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

    //滚动数组 对于数字n 只会关系n-1 和 n-2的数据，空间复杂度O(1)
    public static int climbStairs2(int n) {
        if(n < 3) {
            return n;
        }

        int[] nums = new int[3];
        nums[1] = 1;
        nums[2] = 2;

        for (int i = 3; i <= n; i++) {
            nums[i%3] = nums[(i-1)%3] + nums[(i-2)%3];
        }

        return nums[n%3];
    }
}
