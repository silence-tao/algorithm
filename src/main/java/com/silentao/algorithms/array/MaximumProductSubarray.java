package com.silentao.algorithms.array;

/**
 * @Description
 * 152. 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @Author Silence
 * @Date 2020/4/14 22:27
 **/
public class MaximumProductSubarray {

    /**
     * 标签：动态规划
     * 遍历数组时计算当前最大值，不断更新
     * 令max为当前最大值，则当前最大值为 max = max(max * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。
     * 因此还需要维护当前最小值min，min = min(min * nums[i], nums[i])
     * 当负数出现时则max与min进行交换再进行下一步计算
     * 时间复杂度：O(n)
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int i = 0; i < len; i++) {
            // 交换max和min的值
            if (nums[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            res = Math.max(res, max);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-4, -3};
        System.out.println(maxProduct(arr));
    }
}
