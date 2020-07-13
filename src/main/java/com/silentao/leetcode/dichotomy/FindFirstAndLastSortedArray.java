package com.silentao.leetcode.dichotomy;

/**
 * @Description
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @Author Silence
 * @Date 2020/7/13 21:54
 **/
public class FindFirstAndLastSortedArray {

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0 || target < nums[0] || target > nums[len - 1]) {
            return new int[] {-1, -1};
        }

        int left = 0, right = len - 1;
        // 这种方式得出结果
        // 如果nums[left] == target
        // 那么left就是第一个等于target的元素
        while (left < right) {
            int mid = (left + right) >>> 1;

            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return new int[] {-1, -1};
        }

        // 所以这里只需从left遍历右边的数
        // 直到最后一个等于target的元素
        int[] res = new int[] {left, left};
        for (int i = left + 1; i < len; i++) {
            if (target == nums[i]) {
                res[1] = i;
            } else {
                break ;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2};
        int target = 2;

        int[] res = searchRange(nums, target);
        System.out.println(res[0] + ", " + res[1]);
    }
}
