package com.silentao.leetcode.sort;

import com.silentao.util.PrintUtils;

/**
 * @Description
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 * @Author Silence
 * @Date 2020/8/1 7:59
 **/
public class SortColors {

    /**
     * 左右指针加移动指针pos
     * pos所在位置等于0，和left交换
     * pos所在位置等于2，和right交换
     * pos所在位置等于1，后移一个位置
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return ;
        }

        int left = -1, pos = 0, right = len;
        // pos == right时结束循环
        while (pos < right) {
            int item = nums[pos];
            if (item == 0) {
                // pos所在位置等于0，和left交换
                // left，pos都后移一位
                swap(nums, ++left, pos++);
            } else if (item == 1) {
                // pos所在位置等于1
                // 后移一个位置
                pos++;
            } else if (item == 2) {
                // pos所在位置等于0，和right交换
                // 因为从right交换过来的元素，可能为0或1，所以这里pos位置不变
                // 下次循环再校验一下这个位置的值
                // right前移一个位置
                swap(nums, --right, pos);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return ;
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        PrintUtils.print(nums);
        sortColors(nums);
        PrintUtils.print(nums);
    }
}
