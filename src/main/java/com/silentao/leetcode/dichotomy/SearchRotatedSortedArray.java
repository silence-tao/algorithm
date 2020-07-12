package com.silentao.leetcode.dichotomy;

/**
 * @Description
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @Author Silence
 * @Date 2020/7/12 13:59
 **/
public class SearchRotatedSortedArray {

    /**
     * 二分法
     * 先找出升序序列，在决定怎么缩小范围
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return -1;
        }

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                // [left, mid]是升序序列
                if (target < nums[mid] && target >= nums[left]) {
                    // 表示target在中[left, mid]，所以right = mid - 1
                    right = mid - 1;
                } else {
                    // (mid, right]非升序序列，target在这个区间则left = mid + 1
                    left = mid + 1;
                }
            } else {
                // [mid, right]是升序序列
                if (target > nums[mid] && target <= nums[right]) {
                    // 表示target在中[mid, right]，所以left = mid + 1
                    left = mid + 1;
                } else {
                    // [left, mid)非升序序列，target在这个区间则right = mid - 1
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // [4,5,6,7,0,1,2], target = 0
        int[] nums = new int[] {5, 1, 3};
        System.out.println(search(nums, 3));
    }
}
