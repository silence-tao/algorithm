package com.silentao.leetcode.sort;

import com.silentao.util.PrintUtils;

/**
 * @Description
 * 31. 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 * @Author Silence
 * @Date 2020/7/12 13:00
 **/
public class NextPermutation {

    /**
     * 从右往左遍历升序序列，遍历到最后一个元素或者遍历到非升序序列时结束
     * 如果整个数组从右往左都是升序序列，之间反转整个数组，直接返回
     * 否则找到第一个非升序序列的元素 i
     * 然后和升序序列中的第一个大于 i 的元素交换位置
     * 然后再反转这个升序序列
     *
     * 题解：
     * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode/
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return ;
        }

        // 从右往左遍历升序序列
        int i = len - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break ;
            }
        }

        // i == -1 表示整个数组从右往左都是升序序列
        if (i == -1) {
            // 直接反转整个数组
            reverse(nums, 0);

            return ;
        }

        // [i + 1, len - 1] 从右往左是一个升序序列
        // 升序序列第一个大于i的元素
        int large = i + 1;
        for (int j = i + 1; j < len; j++) {
            if (nums[i] < nums[j]) {
                large = j;
            }
        }

        // 然后交换i和large两个位置的元素
        swap(nums, i, large);
        // 反转整个升序序列
        reverse(nums, i + 1);
    }

    /**
     * 反转 st -> nums.length 之间的元素
     * @param nums
     * @param st
     */
    private static void reverse(int[] nums, int st) {
        int left = st, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);

            left++;
            right--;
        }
    }

    /**
     * 交换数组中i、j两个位置的元素
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // 1,2,3 → 1,3,2
        // 3,2,1 → 1,2,3
        // 1,1,5 → 1,5,1
        // [1,3,2] > 2,1,3

        int[] nums = new int[] {1,3,2};
        nextPermutation(nums);

        PrintUtils.print(nums);
    }
}
