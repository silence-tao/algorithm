package com.silentao.leetcode.dichotomy;

/**
 * @Description
 * 287. 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @Author Silence
 * @Date 2020/7/6 22:09
 **/
public class FindTheDuplicateNumber {

    /**
     * 官方题解讲得比较好，二分法居然还能这样用
     * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
     * ans 表示nums 数组中小于等于 i 的数有多少个
     * target表示重复的数字
     * 其中[1, target - 1] <= i
     * [target, n - 1] > i
     * 满足递增性质，所以可以用二分法
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1, res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 保存 <= num 的元素个数
            int ans = 0;

            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    ans++;
                }
            }

            if (ans <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,4,2,2};

        System.out.println(findDuplicate(nums));
    }
}
