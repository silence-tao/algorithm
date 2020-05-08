package com.silentao.leetcode.graph;

/**
 * @Description
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * @Author Silence
 * @Date 2020/5/8 22:43
 **/
public class NumberIslands {

    /**
     * 把相邻的“1”连接起来
     * 统计能够连接在一起的岛屿数量
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int w, h;
        if (grid == null || (h = grid.length) == 0) {
            return 0;
        }

        w = grid[0].length;

        boolean[][] visited = new boolean[h][w];

        int res = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visitIsland(grid, visited, i, j, w, h)) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 把相邻的“1”连接起来组成一个完整的岛屿
     * 并把访问过的“1”标记起来
     * @param grid
     * @param visited
     * @param i
     * @param j
     * @param w
     * @param h
     * @return
     */
    private static boolean visitIsland(char[][] grid, boolean[][] visited, int i, int j, int w, int h) {
        if (i < 0 || i >= h || j < 0 || j >= w || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        if (grid[i][j] == '0') {
            return false;
        }

        // 上右下左
        visitIsland(grid, visited, i - 1, j , w, h);
        visitIsland(grid, visited, i, j + 1, w, h);
        visitIsland(grid, visited, i + 1, j, w, h);
        visitIsland(grid, visited, i, j - 1, w, h);

        return true;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'}
        };

        System.out.println(numIslands(grid));
    }
}
