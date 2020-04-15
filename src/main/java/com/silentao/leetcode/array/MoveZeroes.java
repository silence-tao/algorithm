package com.silentao.leetcode.array;

import com.silentao.util.PrintUtils;

/**
 * @Description
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * @Author Silence
 * @Date 2020/4/15 22:32
 **/
public class MoveZeroes {

    /**
     * 因为确定是要将0移动到末尾
     * 先将所有非0的数按顺序放到数组中
     * 剩下的位置补0即可
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return ;
        }

        int s = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[s++] = nums[i];
            }
        }

        for (int i = s; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        // [0,0,1]

        int[] nums = new int[] {0,0,1};

        moveZeroes(nums);

        PrintUtils.print(nums);
    }
}
