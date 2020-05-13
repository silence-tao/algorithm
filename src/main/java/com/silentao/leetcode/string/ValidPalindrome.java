package com.silentao.leetcode.string;

/**
 * @Description
 * 125. 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/
 * @Author Silence
 * @Date 2020/5/14 7:35
 **/
public class ValidPalindrome {

    /**
     * 利用左右指针
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return true;
        }

        // 忽略大小写，所以这里把字符串转为小写字母
        s = s.toLowerCase();

        // 左右指针
        int left = 0, right = len - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (!isNumberOrLetter(l)) {
                left++;
            } else if (!isNumberOrLetter(r)) {
                right--;
            } else {
                if (l != r) {
                    return false;
                }

                left++;
                right--;
            }
        }


        return true;
    }

    /**
     * 判断字符c是否为数字或者小写字母
     * @param c
     * @return
     */
    private static boolean isNumberOrLetter(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
