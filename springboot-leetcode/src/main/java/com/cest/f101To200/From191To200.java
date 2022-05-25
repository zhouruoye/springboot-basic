package com.cest.f101To200;

public class From191To200 {

    public static void main(String[] args) {
        int[] dataSize = {0,1};

        int rob = rob(dataSize);

        System.out.println(rob);
    }

    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * 示例 1：
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 动态规划
     * 如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k~(k>2)k (k>2) 间房屋，有两个选项：
     * 偷窃第 kk 间房屋，那么就不能偷窃第 k-1 间房屋，偷窃总金额为前 k-2 间房屋的最高总金额与第 kk 间房屋的金额之和。
     * 不偷窃第 kk 间房屋，偷窃总金额为前 k-1 间房屋的最高总金额。
     * 边界条件为：
     * 只有一间房屋，则偷窃该房屋
     * 只有两间房屋，选择其中金额较高的房屋进行偷窃
     */
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        int[] robtotalMoney = new int[length + 1];
        robtotalMoney[1] = nums[0];

        if(length == 1) {
            return robtotalMoney[length];
        }

        robtotalMoney[2] = Math.max(nums[0],nums[1]);

        for (int i = 3; i <= length; i++) {
            robtotalMoney[i] = Math.max(robtotalMoney[i-1],robtotalMoney[i-2] + nums[i-1]);
        }

        return robtotalMoney[length];
    }
}
