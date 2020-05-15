package com.silentao.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * @Author Silence
 * @Date 2020/5/15 7:35
 **/
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int len;
        if (s == null || (len = s.length()) == 0) {
            return res;
        }

        List<String> path = new ArrayList<>();
        partition(s, 0, len, path, res);

        return res;
    }

    /**
     * 回溯法将回文子串找出
     * @param s
     * @param st
     * @param len
     * @param path
     * @param res
     */
    public void partition(String s, int st, int len, List<String> path, List<List<String>> res) {
        if (st == len) {
            // 表示找到一种分割分案
            // 将结果添加到res
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = st; i < len; i++) {
            if (!isPalindrome(s, st, i)) {
                continue ;
            }

            // [st, i]是回文子串，添加到path
            path.add(s.substring(st, i + 1));
            // 递归[i + 1, len]的回文串
            partition(s, i + 1, len, path, res);
            // 删除刚刚添加的回文子串
            path.remove(path.size() - 1);
        }
    }

    /**
     * 判断子串是否为回文串
     * @param s
     * @param left
     * @param right
     * @return
     */
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
