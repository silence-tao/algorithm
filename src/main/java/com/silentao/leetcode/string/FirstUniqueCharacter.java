package com.silentao.leetcode.string;

/**
 * @Description 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/submissions/
 * @Author Silence
 * @Date 2020/6/8 22:51
 **/
public class FirstUniqueCharacter {

    /**
     * 利用整形数组保存字母出现的次数
     * 返回出现了一次的字母所在的下标
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return -1;
        }

        int[] letters = new int[26];
        for (int i = 0; i < len; i++) {
            letters[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (letters[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
