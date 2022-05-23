package com.cest.f701to800;

public class From731To740 {

    public static void main(String[] args) {
        int[] scores = new int[]{73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(scores);

        System.out.println(111);
    }

    /**
     * 739. 每日温度
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 示例 1:
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return temperatures;
        }

        int[] highTempers = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            highTempers[i] = getHighTemper(temperatures,i);
        }

        return highTempers;
    }

    public static int getHighTemper(int[] temperatures,int index) {
        if(temperatures.length == (index + 1)) {
            return 0;
        }
        int temperature = temperatures[index];

        for (int i = index; i < temperatures.length; i++) {
            if(temperature < temperatures[i]) {
                return (i - index);
            }
        }
        return 0;
    }
}
