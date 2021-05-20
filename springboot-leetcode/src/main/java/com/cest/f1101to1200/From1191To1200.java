package com.cest.f1101to1200;

import java.util.Arrays;

public class From1191To1200 {

    public static void main(String[] args) {
        int[] arr = new int[]{900,950,800,1000,700,800};
        System.out.println(maxNumberOfApples(arr));
    }

    /**
     * 1196. 最多可以买到的苹果数量
     * 楼下水果店正在促销，你打算买些苹果，arr[i] 表示第 i 个苹果的单位重量。
     * 你有一个购物袋，最多可以装 5000 单位重量的东西，算一算，最多可以往购物袋里装入多少苹果。
     * 示例 1：
     * 输入：arr = [100,200,150,1000]
     * 输出：4
     * 解释：所有 4 个苹果都可以装进去，因为它们的重量之和为 1450。
     * @return
     */
    public static int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);

        int total = 5000;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if(count > total) {
                return i;
            }
        }

        return arr.length;
    }
}
