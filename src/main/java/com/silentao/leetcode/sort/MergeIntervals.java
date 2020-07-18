package com.silentao.leetcode.sort;

import java.util.*;

/**
 * @Description
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * @Author chentao10
 * @Date 2020/7/17 11:26
 **/
public class MergeIntervals {

    /**
     * 先根据区间的起始位置排序，再进行 n -1n−1 次 两两合并
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int len;
        if (intervals == null || (len = intervals.length) == 0) {
            return new int[0][0];
        }

        // 按起始位置排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int pos = -1;
        int[][] ans = new int[len][2];
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (pos == -1 || interval[0] > ans[pos][1]) {
                ans[++pos] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                ans[pos][1] = Math.max(ans[pos][1], interval[1]);
            }
        }

        // 截取结果
        return Arrays.copyOf(ans, pos + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,4},{0,5},{15,18}};

        int[][] ans = merge(intervals);
        for (int ints[] : ans) {
            System.out.println(ints[0] + ", " + ints[1]);
        }
    }
}
