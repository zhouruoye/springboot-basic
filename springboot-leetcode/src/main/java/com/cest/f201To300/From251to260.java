package com.cest.f201To300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class From251to260 {

    public static void main(String[] args) {
        int[][] arr = {{5, 10}, {0, 30}, {15, 20}};
        canAttendMeetings(arr);
    }

    /**
     * 252. 会议室
     * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
     *  
     * 示例 1：
     * 输入：intervals = [[0,30],[5,10],[15,20]]
     * 输出：false
     * 示例 2：
     * 输入：intervals = [[7,10],[2,4]]
     * 输出：true
     *
     * @param intervals
     * @return
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;

            }
        }
        return true;
    }
}
