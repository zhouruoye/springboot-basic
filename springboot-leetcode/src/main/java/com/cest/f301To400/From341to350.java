package com.cest.f301To400;

import java.util.ArrayDeque;
import java.util.Deque;

public class From341to350 {

    private Deque<Integer> list;
    private int size;
    private int sum;

    public From341to350(int size) {
        this.list = new ArrayDeque<>();
        this.size = size;
    }

    public static void main(String[] args) {
        From341to350 from341to350 = new From341to350(3);
        double next1 = from341to350.next(1);
        double next2 =from341to350.next(10);
        System.out.println(111);

    }

    /**
     * 346. 数据流中的移动平均值
     * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
     * 实现 MovingAverage 类：
     * MovingAverage(int size) 用窗口大小 size 初始化对象。
     * double next(int val) 计算并返回数据流中最后 size 个值的移动平均值。
     *  示例：
     * 输入：
     * ["MovingAverage", "next", "next", "next", "next"]
     * [[3], [1], [10], [3], [5]]
     * 输出：
     * [null, 1.0, 5.5, 4.66667, 6.0]
     * 解释：
     * MovingAverage movingAverage = new MovingAverage(3);
     * movingAverage.next(1); // 返回 1.0 = 1 / 1
     * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
     * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
     * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
     *
     * 思路 使用队列
     */
    public double next(int val) {
        sum += val;
        if(size == list.size()) {
            //出队
            Integer pop = list.pop();
            sum -= pop;
        }
        list.add(val);
        return (double) sum/(double)list.size();
    }
}
