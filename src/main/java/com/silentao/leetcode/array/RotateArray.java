package com.silentao.leetcode.array;

/**
 * @Description
 * 189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 * @Author Silence
 * @Date 2020/4/14 23:36
 **/
public class RotateArray {

    /**
     * 按正常逻辑一步一步移动
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k <= 0) {
            return ;
        }

        // 这一步很关键，可以减少很多移动操作
        k = k % len;
        while (k-- > 0) {
            int last = nums[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }

            nums[0] = last;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        rotate1(nums, 3);
    }
}
