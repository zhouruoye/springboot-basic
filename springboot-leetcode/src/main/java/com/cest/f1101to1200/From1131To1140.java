package com.cest.f1101to1200;

import java.util.HashMap;
import java.util.Map;

public class From1131To1140 {

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,3,9,4,9,8,3,1};
        largestUniqueNumber(arr);
//        1134. 阿姆斯特朗数
//        System.out.println(isArmstrong(154));
    }

    /**
     * 1133. 最大唯一数
     * 给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
     * 如果不存在这个只出现一次的整数，则返回 -1。
     * 示例 1：
     * 输入：[5,7,3,9,4,9,8,3,1]
     * 输出：8
     * 解释：
     * 数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
     * 示例 2：
     * 输入：[9,9,8,8]
     * 输出：-1
     * 解释：
     * 数组中不存在仅出现一次的整数。
     * @param A
     * @return
     */
    public static int largestUniqueNumber(int[] A) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.put(A[i],map.getOrDefault(A[i],0) + 1);
        }

        int tmp = -1;

        for (Integer integer : map.keySet()) {
            if(map.get(integer) == 1) {
                if(integer.intValue() > tmp) {
                    tmp = integer;
                }
             }
        }
        return tmp;
    }

    /**
     * 1134. 阿姆斯特朗数
     * 假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
     * 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
     * 输入：153
     * 输出：true
     * 示例：
     * 153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
     * @param n
     * @return
     */
    public static boolean isArmstrong(int n) {
        if(n <= 0) {
            return false;
        }

        int count = 0;
        int num = n;
        int length = String.valueOf(n).length();

        for (int i = 0; i < length; i++) {
            //求余
            int j = num%10;

            count += Math.pow(j,length);

            num = num/10;
        }

        return count == n;
    }
}
