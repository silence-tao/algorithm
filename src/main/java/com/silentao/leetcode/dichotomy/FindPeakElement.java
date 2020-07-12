package com.silentao.leetcode.dichotomy;

/**
 * @Description
 * 162. 寻找峰值
 * https://leetcode-cn.com/problems/find-peak-element/
 * 题解：https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
 * @Author Silence
 * @Date 2020/7/4 16:56
 **/
public class FindPeakElement {

    /**
     * 只需比较 nums[i] > nums[i + 1] 即可知道 nums[i] 是不是峰值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int len;
        for (int i = 0; i < (len = nums.length - 1); i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return len;
    }

    /**
     * 利用二分法：将数组分割成交替的升序或降序的序列
     * @param nums
     * @return
     */
    public static int findPeakElement1(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,1,3,5,6,4};

        System.out.println(findPeakElement1(nums));
    }
}
