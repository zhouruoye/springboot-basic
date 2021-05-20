package com.cest.f1501To1600;

public class From1551to1560 {

    public static void main(String[] args) {
        System.out.println(minOperations(6));
    }

    /**
     * 1551. 使数组中所有元素相等的最小操作数
     * 存在一个长度为 n 的数组 arr ，其中 arr[i] = (2 * i) + 1 （ 0 <= i < n ）。
     * 一次操作中，你可以选出两个下标，记作 x 和 y （ 0 <= x, y < n ）并使 arr[x] 减去 1 、arr[y] 加上 1 （即 arr[x] -=1 且 arr[y] += 1 ）。最终的目标是使数组中的所有元素都 相等 。题目测试用例将会 保证 ：在执行若干步操作后，数组中的所有元素最终可以全部相等。
     * 给你一个整数 n，即数组的长度。请你返回使数组 arr 中所有元素相等所需的 最小操作数 。
     *
     * 输入：n = 3
     * 输出：2
     * 解释：arr = [1, 3, 5]
     * 第一次操作选出 x = 2 和 y = 0，使数组变为 [2, 3, 4]
     * 第二次操作继续选出 x = 2 和 y = 0，数组将会变成 [3, 3, 3]
     *
     * 1 3 5 --> 2 奇数 n*n-1/4   1 3 5 7 --> 1 + 3  偶数 n*n/4 1 3 5 7 9 -> 2 + 4  1 3 5 7 9 11 -> 1 + 3 + 5
     *
     */
    public static int minOperations(int n) {
        return (n*n - n%2) /4;
    }

    /**
     * todo 暂时没思路
     * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
     *
     * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
     *
     * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
     *
     * @param position
     * @param m
     * @return
     */
    public static int maxDistance(int[] position, int m) {
        return 0;
    }
}
