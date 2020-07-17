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
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int len;
        if (intervals == null || (len = intervals.length) == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] > o2[0] ? 1 : o1[0] > o2[0] ? 0 : -1);

        Stack<int []> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] temp = stack.peek();
            int[] item = intervals[i];

            if (temp[1] >= item[0]) {
                int[] ints = new int[2];
                ints[0] = temp[0];

                if (temp[1] >= item[1]) {
                    ints[1] = temp[1];
                } else {
                    ints[1] = item[1];
                }

                stack.pop();
                stack.push(ints);
            } else {
                stack.push(item);
            }
        }

        int[][] ans = new int[stack.size()][2];
        int k = 0;
        while (!stack.isEmpty()) {
            ans[k++] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,4},{0,5},{15,18}};

        int[][] ans = merge(intervals);
        for (int ints[] : ans) {
            System.out.println(ints[0] + ", " + ints[1]);
        }
    }
}
