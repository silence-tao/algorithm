package com.silentao.leetcode.math;

/**
 * @Description
 * 268. 缺失数字
 * https://leetcode-cn.com/problems/missing-number/
 * @Author Silence
 * @Date 2020/5/6 22:53
 **/
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return 0;
        }

        boolean[] memory = new boolean[length + 1];
        for (int i = 0; i < length; i++) {
            memory[nums[i]] = true;
        }

        int res = 0;
        for (int i = 0; i <= length; i++) {
            if (!memory[i]) {
                res = i;
                break ;
            }
        }

        return res;
    }
}
