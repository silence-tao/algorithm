package com.silentao.leetcode.math;

/**
 * @Description
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 * @Author Silence
 * @Date 2020/4/23 23:18
 **/
public class SingleNumber {

    /**
     * 利用异或运算，相同的数做异或运算得0
     * 任何数和0做异或运算得其本身
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }
}
