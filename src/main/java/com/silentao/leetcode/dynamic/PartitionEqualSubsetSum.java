package com.silentao.leetcode.dynamic;

import java.util.Arrays;

/**
 * @Description
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @Author Silence
 * @Date 2020/7/20 7:53
 **/
public class PartitionEqualSubsetSum {

    /**
     * 动态规划
     * 先计算出数组nums中所有元素的和sum
     * 然后递归看数组中是否存在相加等于sum一半的序列
     * 如果存在返回true，否则返回false
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return false;
        }

        int sum = 0;
        // 求和
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        // 排序是为了在递归时达到剪枝的效果
        Arrays.sort(nums);

        // 和为奇数，显然不存在这样的分割方式
        if (sum % 2 == 1) {
            return false;
        }

        return helper(nums, 0, sum / 2);
    }

    /**
     * 递归看数组中是否存在相加等于sum一半的序列
     * @param nums
     * @param st
     * @param left
     * @return
     */
    private static boolean helper(int[] nums, int st, int left) {
        if (left == 0) {
            return true;
        }

        if (st >= nums.length || left < 0) {
            return false;
        }

        for (int i = st; i < nums.length; i++) {
            if (i > st && nums[i - 1] == nums[i]) {
                // 相同的元素不需要再判断
                continue ;
            }

            if (helper(nums, i + 1, left - nums[i])) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 5, 11, 5};

        System.out.println(canPartition(nums));
    }
}
