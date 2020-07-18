package com.silentao.leetcode.search;

/**
 * @Description
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 * @Author Silence
 * @Date 2020/7/15 22:13
 **/
public class WordSearch {

    /**
     * 回溯法
     * 用二维的boolean数组path来保存访问过的路径
     * 访问过的置位true，访问结束再置位false，用于回溯
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        int h, w;
        if (board == null || (h = board.length) == 0 || (w = board[0].length) == 0
                || word == null || word.length() == 0) {
            return false;
        }

        // 用于记录访问路径
        boolean[][] path = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 以board每个位置位起点开始回溯
                // 如果有完整路径就返回true
                if (exist(board, i, j, word, 0, path)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 回溯过程
     * 按照上右下左的顺序进行回溯，顺序可以任意
     * 访问前状态置为true，表示已访问
     * 访问完状态置为false，状态重置
     * @param board
     * @param i
     * @param j
     * @param word
     * @param k
     * @param path
     * @return
     */
    private static boolean exist(char[][] board, int i, int j, String word, int k, boolean[][] path) {
        int len;
        // 边界判断
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || path[i][j] || k >= (len = word.length())) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            if (k == len - 1) {
                // 如果是字符串里的最后一个字符
                // 表示搜索到了单词直接返回true
                return true;
            }

            // 先标记为true表示位置i,j已访问
            path[i][j] = true;
            // 这里按照左上右下的顺序搜索，使用的是或，只要有一条路径成功，就直接返回了
            boolean ans = exist(board, i - 1, j, word, k + 1, path)
                    || exist(board, i, j - 1, word, k + 1, path)
                    || exist(board, i + 1, j, word, k + 1, path)
                    || exist(board, i, j + 1, word, k + 1, path);

            // 状态重置
            path[i][j] = false;

            return ans;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
                };

        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }
}
