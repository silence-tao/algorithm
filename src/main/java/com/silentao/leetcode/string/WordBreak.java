package com.silentao.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * @Author Silence
 * @Date 2020/5/19 7:37
 **/
public class WordBreak {

    /**
     * 暴力破解
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0, new Boolean[s.length()]);
    }

    /**
     * timeout
     * @param s
     * @param wordDict
     * @param st
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict, int st) {
        if (s.length() == st) {
            return true;
        }

        for (int i = st + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(st, i)) && wordBreak(s, wordDict, i)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 带备忘录的解法
     * @param s
     * @param wordDict
     * @param st
     * @param memory
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict, int st, Boolean[] memory) {
        if (s.length() == st) {
            return true;
        }

        if (memory[st] != null) {
            return memory[st];
        }

        for (int i = st + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(st, i)) && wordBreak(s, wordDict, i, memory)) {
                return memory[st] = true;
            }
        }

        return memory[st] = false;
    }

    public static void main(String[] args) {
        // s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(wordBreak(s, wordDict));
    }
}
