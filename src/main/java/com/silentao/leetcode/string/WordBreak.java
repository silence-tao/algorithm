package com.silentao.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Silence
 * @Date 2020/5/19 7:37
 **/
public class WordBreak {

    /**
     * 暴力破解
     * 139. 单词拆分
     * https://leetcode-cn.com/problems/word-break/
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

    /**
     * 回溯法暴力破解
     * 140. 单词拆分 II
     * https://leetcode-cn.com/problems/word-break-ii/
     * @param s
     * @param wordDict
     * @return
     */
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        Map<Integer, List<String>> map = new HashMap<>();
        return wordBreak2(s, wordDict, 0, map);
    }

    public static List<String> wordBreak2(String s, List<String> wordDict, int st, Map<Integer, List<String>> map) {
        if (map.containsKey(st)) {
            return map.get(st);
        }

        List<String> res = new ArrayList<>();
        if (s.length() == st) {
            // 这一步是为了标识结束了
            res.add("");
        }

        for (int i = st + 1; i <= s.length(); i++) {
            String sub = s.substring(st, i);
            if (wordDict.contains(sub)) {
                List<String> list = wordBreak2(s, wordDict, i, map);
                for (String str : list) {
                    res.add(sub + (str.equals("") ? "" : " ") + str);
                }
            }
        }

        map.put(st, res);
        return res;
    }

    public static void main(String[] args) {
        // s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreak2(s, wordDict));
    }
}
