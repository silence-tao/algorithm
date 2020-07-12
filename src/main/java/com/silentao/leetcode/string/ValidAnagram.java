package com.silentao.leetcode.string;

/**
 * @Description 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * @Author Silence
 * @Date 2020/6/7 12:53
 **/
public class ValidAnagram {

    /**
     * 利用一个长度为26的整形数组记录出现字母的次数
     * s中出现的字母就+1
     * t中出现的字母就-1
     * 如果整形数组所有元素都为0
     * 就表示t是s的有效字母异位词
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen != tLen) {
            return false;
        }

        // 用来表示字母出现的次数
        int[] strs = new int[26];

        for (int i = 0; i < sLen; i++) {
            // s和t出现的字母的次数相互抵消
            strs[s.charAt(i) - 'a']++;
            strs[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (strs[i] != 0) {
                // 只要有一个字母出现的次数不是0
                // 就返回false
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
