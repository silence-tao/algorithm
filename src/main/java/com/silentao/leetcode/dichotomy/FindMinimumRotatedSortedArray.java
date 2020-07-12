package com.silentao.leetcode.dichotomy;

/**
 * @Description
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @Author Silence
 * @Date 2020/7/7 23:04
 **/
public class FindMinimumRotatedSortedArray {

    /**
     * 迭代法
     * 找到 nums[i] > nums[i + 1]
     * 那么 i + 1 就是最小值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int len = nums.length;

        int res = nums[0];
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                res = nums[i + 1];
            }
        }

        return res;
    }

    /**
     * 二分法
     * 题解：
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-lie-shu-zu-zhong-de-zui-xi/
     * 加入分界点为最小值的位置为 min
     * 因为递增数组被反转了，必定会有 nums[0, min - 1] > nums[right]，即[0, min - 1]是递增序列分段
     * 所以在进行二分法时，当nums[mid] > nums[right]，表示[0, mid]是递增序列分段，min还在右边，所以此时 left = mid + 1
     * nums[mid] < nums[right]，表示[min, mid]是递增序列分段，min在左边，所以此时 right = mid
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int len = nums.length;

        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
