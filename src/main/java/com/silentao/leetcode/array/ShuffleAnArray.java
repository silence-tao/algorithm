package com.silentao.leetcode.array;

import java.util.Random;

/**
 * @Description
 * 384. 打乱数组
 * https://leetcode-cn.com/problems/shuffle-an-array/
 * @Author Silence
 * @Date 2020/4/15 23:10
 **/
public class ShuffleAnArray {

    /**
     * 洗牌法
     */
    class Solution {
        int[] src;
        int[] arr;
        int len;

        Random random = new Random();

        public Solution(int[] nums) {
            len = nums.length;

            src = new int[len];
            arr = new int[len];
            for (int i = 0; i < len; i++) {
                src[i] = arr[i] = nums[i];
            }
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return src;
        }

        /**
         * 从第一个元素开始，随机的和后面的元素交换
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < len; i++) {
                swap(i, getRandom(i, len));
            }

            return arr;
        }

        private void swap(int i, int j) {
            if (i == j) {
                return ;
            }

            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

        private int getRandom(int min, int max) {
            return random.nextInt(max - min) + min;
        }
    }
}
