package com.cest.f1101to1200;

public class From1131To1140 {

    public static void main(String[] args) {

        System.out.println(isArmstrong(154));
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
