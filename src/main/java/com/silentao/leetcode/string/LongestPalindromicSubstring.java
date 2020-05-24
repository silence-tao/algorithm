package com.silentao.leetcode.string;

/**
 * @Description
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @Author chentao10
 * @Date 2020/5/21 9:34
 **/
public class LongestPalindromicSubstring {

    /**
     * 暴力破解
     * 遍历每个字符并和后面的字符比较，遇到相等的字符就看区间内是否为回文字符串
     * 再取长度最长的一个
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return "";
        }

        int max = 0;
        String res = "";
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            for (int j = i; j < len; j++) {
                if (c == s.charAt(j) && max < j - i + 1 && isPalindrome(s, i, j)) {
                    res = s.substring(i, j + 1);
                    max = j - i + 1;
                }
            }
        }

        return res;
    }

    /**
     * 判断[left, right]之间的子串是否为回文字符串
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
