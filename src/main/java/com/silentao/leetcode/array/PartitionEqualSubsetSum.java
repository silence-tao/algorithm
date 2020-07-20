package com.silentao.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @Author Silence
 * @Date 2020/7/20 7:53
 **/
public class PartitionEqualSubsetSum {

    /**
     * 暴力破解
     * 超出时间限制
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        helper(nums, 0, sum /= 2, list);

        for (int num : nums) {
            int index;
            if ((index = list.indexOf(num)) == -1) {
                sum -= num;
            } else {
                list.remove(index);
            }
        }

        return sum == 0;
    }

    private static boolean helper(int[] nums, int st, int left, List<Integer> list) {
        if (left == 0) {
            return true;
        }

        if (st >= nums.length) {
            return false;
        }

        for (int i = st; i < nums.length; i++) {
            boolean ans = helper(nums, i + 1, left - nums[i], list);

            if (ans) {
                list.add(nums[i]);

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
