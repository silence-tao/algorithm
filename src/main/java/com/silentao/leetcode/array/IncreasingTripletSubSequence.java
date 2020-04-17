package com.silentao.leetcode.array;

/**
 * @Description
 * 334. 递增的三元子序列
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * @Author Silence
 * @Date 2020/4/17 21:49
 **/
public class IncreasingTripletSubSequence {

    /**
     * 用min，mid分别表示序列中的前两个数
     * 当遇到数小于min或者mid时就更新它们
     * 当遇到的数都大于min和mid时表示已经找到了符合的序列
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return false;
        }

        int min, mid = min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int num;
            if ((num = nums[i]) <= min) {
                // 小于min，更新min
                min = num;
            } else if (num <= mid) {
                // 小于mid，更新mid
                mid = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 9, 3, 5, 4};
        System.out.println(increasingTriplet(nums));
    }
}
