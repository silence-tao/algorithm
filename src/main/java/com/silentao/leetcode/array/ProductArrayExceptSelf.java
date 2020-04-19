package com.silentao.leetcode.array;

import com.silentao.util.PrintUtils;

/**
 * @Description
 * 238. 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * @Author Silence
 * @Date 2020/4/19 23:42
 **/
public class ProductArrayExceptSelf {

    /**
     * 先正三角乘积运算再倒三角乘积运算
     * nums = {1,2,3,4}
     *        {0,2*3*4}
     *        {1,0,3*4}
     *        {1*2,0,4}
     *        {1*2*3,0}
     * res = {24,12,8,6}
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return nums;
        }

        int[] res = new int[len];
        // 正三角乘积运算
        for (int i = 0; i < len; i++) {
            res[i] = 1;
            if (i == 0) {
                continue ;
            }

            res[i] = res[i - 1] * nums[i - 1];
        }

        int t = 1;
        // 倒三角乘积运算
        for (int i = len - 2; i >= 0; i--) {
            t *= nums[i + 1];
            res[i] *= t;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};

        PrintUtils.print(productExceptSelf(arr));
    }
}
