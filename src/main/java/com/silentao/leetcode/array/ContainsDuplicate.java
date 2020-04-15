package com.silentao.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 217. 存在重复元素
 * https://leetcode-cn.com/problems/contains-duplicate/
 * @Author Silence
 * @Date 2020/4/14 23:56
 **/
public class ContainsDuplicate {

    /**
     * 用Map记录元素出现次数
     * 只要出现次数大于1就返回true
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return false;
        }

        Map<Integer, Integer> memory = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int sum;
            memory.put(nums[i], sum = (memory.getOrDefault(nums[i], 0) + 1));

            if (sum > 1) {
                return true;
            }
        }

        return false;
    }
}
