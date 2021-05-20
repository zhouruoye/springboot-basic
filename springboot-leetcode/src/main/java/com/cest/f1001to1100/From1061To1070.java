package com.cest.f1001to1100;

public class From1061To1070 {

    public static void main(String[] args) {
        int[] arr = new int[]{-10,-5,0,3,7};
        fixedPoint(arr);
    }

    /**
     * 1064. 不动点
     * 给定已经按 升序 排列、由不同整数组成的数组 arr，返回满足 arr[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。
     * 示例 1：
     * 输入：arr = [-10,-5,0,3,7]
     * 输出：3
     * 解释：对于给定的数组，arr[0] = -10，arr[1] = -5，arr[2] = 0，arr[3] = 3，因此输出为 3 。
     * 示例 2：
     * 输入：arr = [0,2,5,8,17]
     * 输出：0
     * 解释：arr[0] = 0，因此输出为 0 。
     * 示例 3：
     * 输入：arr = [-10,-5,3,4,7,9]
     * 输出：-1
     * 解释：不存在这样的 i 满足 arr[i] = i，因此输出为 -1 。
     * 有序数组考虑二份搜索
     * @param arr
     * @return
     */
    public static int fixedPoint(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
            if (arr[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
