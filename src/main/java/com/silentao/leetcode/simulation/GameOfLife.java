package com.silentao.leetcode.simulation;

/**
 * @Description
 * 289. 生命游戏
 * https://leetcode-cn.com/problems/game-of-life/
 * @Author Silence
 * @Date 2020/4/13 22:19
 **/
public class GameOfLife {

    /**
     * 暴力解法
     * 借助一个与board同等大小的二维数组来辅助实现
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int w, h;
        if (board == null || (h = board.length) == 0
                || board[0] == null || (w = board[0].length) == 0) {
            return ;
        }

        int[][] helper = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                helper[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int t = mark(i - 1, j - 1, h, w, helper);
                t += mark(i - 1, j, h, w, helper);
                t += mark(i - 1, j + 1, h, w, helper);
                t += mark(i, j - 1, h, w, helper);
                t += mark(i, j + 1, h, w, helper);
                t += mark(i + 1, j - 1, h, w, helper);
                t += mark(i + 1, j, h, w, helper);
                t += mark(i + 1, j + 1, h, w, helper);

                if (helper[i][j] == 1 && (t < 2 || t > 3)) {
                    board[i][j] = 0;
                } else if (helper[i][j] == 0 && t == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int mark(int i, int j, int h, int w, int[][] helper) {
        if (i < 0 || j < 0 || i >= h || j >= w) {
            return 0;
        }

        return helper[i][j];
    }
}
