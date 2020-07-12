package com.silentao.leetcode.string;

/**
 * @Description 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 * @Author Silence
 * @Date 2020/6/8 23:00
 **/
public class ReverseString {

    /**
     * 左右指针
     * @param s
     */
    public void reverseString(char[] s) {
        int len;
        if (s == null || (len = s.length) == 0) {
            return ;
        }

        int left = 0, right = len - 1;
        char c;
        while (left < right) {
            c = s[left];
            s[left] = s[right];
            s[right] = c;

            left++;
            right--;
        }
    }
}
