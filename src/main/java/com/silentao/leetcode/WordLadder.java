package com.silentao.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * @Description
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 * @Author Silence
 * @Date 2020/5/7 23:06
 **/
public class WordLadder {

    /**
     * 广度优先遍历
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 字符串长度
        int len = beginWord.length();
        // 通用状态到字符串的映射
        // 将通用状态能匹配上的字符串都放在list里
        Map<String, List<String>> wordCommonMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String com = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> words = wordCommonMap.get(com);
                if (words == null) {
                    words = new ArrayList<>();
                    wordCommonMap.put(com, words);
                }

                words.add(word);
            }
        }

        // 记录访问的层数
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        // 记录已经访问过的字符串
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 广度优先遍历开始
        while (!queue.isEmpty()) {
            // 取出队列中的头节点
            Pair<String, Integer> pair = queue.poll();
            String word = pair.getKey();
            Integer level = pair.getValue();

            // 遍历当前节点字符串对应的所有通用状态能到达的字符串
            // 如果之前没有访问过就加入队列层数+1并标记为已访问
            for (int i = 0; i < len; i++) {
                String com = word.substring(0, i) + "*" + word.substring(i + 1, len);
                List<String> words = wordCommonMap.get(com);
                if (words == null || words.size() == 0) {
                    continue ;
                }

                for (String w : words) {
                    if (endWord.equals(w)) {
                        return level + 1;
                    }

                    if (!visited.contains(w)) {
                        queue.add(new Pair<>(w, level + 1));
                        visited.add(w);
                    }
                }
            }
        }

        return 0;
    }
}
