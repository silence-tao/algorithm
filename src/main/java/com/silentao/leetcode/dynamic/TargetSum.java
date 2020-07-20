package com.silentao.leetcode.dynamic;

/**
 * @Description
 * 494. 目标和
 * https://leetcode-cn.com/problems/target-sum/
 * @Author Silence
 * @Date 2020/7/19 8:13
 **/
public class TargetSum {

    /**
     * 利用递归把所有情况都列举出来
     */
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        findTargetSumWays(nums, S, 0, 0);

        return count;
    }

    /**
     * 递归
     * @param nums
     * @param S
     * @param i
     * @param sum
     */
    public void findTargetSumWays(int[] nums, int S, int i, int sum) {
        if (i == nums.length) {
            // 所有元素都运算完成
            if (S == sum) {
                // 如果结果恰好等于S，count加一
                count++;
            }
         } else {
            // 模拟元素i前为+和-的情况
            findTargetSumWays(nums, S, i + 1, sum + nums[i]);
            findTargetSumWays(nums, S, i + 1, sum - nums[i]);
         }
    }
}
