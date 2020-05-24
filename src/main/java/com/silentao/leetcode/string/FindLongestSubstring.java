package com.silentao.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 1371. 每个元音包含偶数次的最长子字符串
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * @Author Silence
 * @Date 2020/5/20 8:59
 **/
public class FindLongestSubstring {

    /**
     * 利用异或运算规则：相同为0，不同为1
     * 给每个元音字母映射一个2^n的数值
     * 元音字母出现偶次那么就会抵消
     * @param s
     * @return
     */
    public static int findTheLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('a', 1);
        charMap.put('e', 2);
        charMap.put('i', 4);
        charMap.put('o', 8);
        charMap.put('u', 16);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, rex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c;
            if (charMap.containsKey(c = s.charAt(i))) {
                rex ^= charMap.get(c);
            }

            if (map.containsKey(rex)) {
                max = Math.max(max, i - map.get(rex));
            } else {
                map.put(rex, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }
}
