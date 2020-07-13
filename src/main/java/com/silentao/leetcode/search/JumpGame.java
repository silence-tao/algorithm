package com.silentao.leetcode.search;

/**
 * @Description
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * @Author Silence
 * @Date 2020/7/14 0:17
 **/
public class JumpGame {

    /**
     * 要从第一个位置跳到最后一个位置，那么一定不会跳到同一个位置
     * 如果跳到同一个位置，那么说明不能跳到最后一个位置
     * 可以用一个boolean型的数组记录跳到过的位置
     * 在跳的时候已经到过的位置就直接返回false
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return false;
        }

        // 记录已经跳到过的位置
        boolean[] path = new boolean[len];

        return canJump(nums, 0, path);
    }

    /**
     * 递归跳
     * @param nums
     * @param pos
     * @param path
     * @return
     */
    private static boolean canJump(int[] nums, int pos, boolean[] path) {
        int len;
        if (pos < 0 || pos >= (len = nums.length) || path[pos]) {
            return false;
        }

        if (pos == len - 1) {
            return true;
        }

        // 标记位置pos已经到过
        path[pos] = true;

        // 因为nums[pos]是最大跳跃长度
        // 所以这里要遍历一下每一个跳跃长度
        // 左右都要跳
        // 只要一种跳法能跳到最后一个位置，就结束循环
        for (int i = 1; i <= nums[pos]; i++) {
            // pos - i 表示往左跳
            // pos + i 表示往右跳
            if (canJump(nums, pos - i, path)
                    || canJump(nums, pos + i, path)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,0};

        System.out.println(canJump(nums));
    }
}
