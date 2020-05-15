package com.silentao.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @Author Silence
 * @Date 2020/5/15 8:29
 **/
public class SubarraySumEqualsK {

    /**
     * 利用前缀和+Map
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int res = 0;

        // 保存前缀和及出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和为0是特殊情况，初始次数为1
        map.put(0, 1);
        // 保存前缀和
        int t = 0;
        for (int i = 0; i < len; i++) {
            t += nums[i];
            // t - k表示[x, i]的和
            // 其中x <= i
            // 这里就是要看t(x)是否在前缀和集合中
            // 在就加上之前的次数
            if (map.containsKey(t - k)) {
                res += map.get(t - k);
            }

            // 将前缀和放入map中
            map.put(t , map.getOrDefault(t, 0) + 1);
        }

        return res;
    }
}
