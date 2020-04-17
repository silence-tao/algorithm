package com.silentao.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * 350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @Author Silence
 * @Date 2020/4/17 21:29
 **/
public class IntersectionOfTwoArrays {

    /**
     * 利用map记录nums1中的数出现的次数
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1, len2;
        if (nums1 == null || (len1 = nums1.length) == 0 || nums2 == null || (len2 = nums2.length) == 0) {
            return new int[0];
        }

        Map<Integer, Integer> memory = new HashMap<>(len1);
        for (int i = 0; i < len1; i++) {
            memory.put(nums1[i], memory.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len2; i++) {
            int num;
            int sum = memory.getOrDefault(num = nums2[i], 0);
            if (sum == 0) {
                continue ;
            }

            list.add(num);
            memory.put(num, sum - 1);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
