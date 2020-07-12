package com.silentao.leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * 179. 最大数
 * https://leetcode-cn.com/problems/largest-number/
 * @Author Silence
 * @Date 2020/7/4 15:26
 **/
public class LargestNumber {

    /**
     * 先将整型数组转为字符串放到list中
     * 然后进行排序
     * 排序规则是数字前面位数大的排前面
     * 比较字符串的 a + b 和 b + a 即可
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return null;
        }

        List<String> list = new ArrayList<>(len);

        // 统计0的个数
        int zero = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zero++;
            }

            list.add(Integer.toString(nums[i]));
        }

        // 如果全是0，就直接返回0
        if (zero == list.size()) {
            return "0";
        }

        // 排序
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));

        // 拼接字符串即可
        StringBuilder builder = new StringBuilder();
        for (String num : list) {
            builder.append(num);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
