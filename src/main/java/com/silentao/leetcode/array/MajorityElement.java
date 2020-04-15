package com.silentao.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * @Author Silence
 * @Date 2020/4/14 23:20
 **/
public class MajorityElement {

    /**
     * 利用Map记录元素出现的次数
     * 再把元素出现次数大于n / 2
     * 且出现最多次的元素就是我们要的结果
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len, t = (len = nums.length) / 2;
        int sum = 0, res = nums[0];

        Map<Integer, Integer> memory = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int num;
            memory.put(nums[i], num = (memory.getOrDefault(nums[i], 0) + 1));

            if (num > t && num > sum) {
                res = nums[i];
                sum = num;
            }
        }

        return res;
    }
}
