package com.silentao.leetcode.search;

/**
 * @Description
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * @Author Silence
 * @Date 2020/7/17 8:16
 **/
public class MaximalSquare {

    /**
     * 先向右搜索，然后再向下搜索
     * 向下搜索的深度为向右搜索的最大长度
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        int w, h;
        if (matrix == null || (h = matrix.length) == 0 || (w = matrix[0].length) == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans = Math.max(ans, maximalSquare(matrix, i, j));
            }
        }

        return ans;
    }

    /**
     * 以每一个matrix[i][j] == 1的位置作为起点进行搜索
     * 一行一行搜索，取各行中最小长度作为高度
     * 再取搜索的高度和最小长度的最小值作为边长
     * 这个边长的平方就是最小面积
     * @param matrix
     * @param i
     * @param j
     * @return
     */
    private static int maximalSquare(char[][] matrix, int i, int j) {
        if (matrix[i][j] == '0') {
            return 0;
        }

        int h = matrix.length, w = matrix[0].length;
        int len = w + 1, height = 0;
        for (int m = i; m < h; m++) {
            int l = 0;
            for (int n = j; n < w; n++) {
                // 向右搜索
                if (matrix[m][n] == '1') {
                    // 长度+1
                    l++;
                } else {
                    // matrix[m][n] == '0'不符合条件，这里直接break
                    break ;
                }
            }

            if (l == 0)  {
                // 当前行长度为0也直接break
                break ;
            }

            // 高度+1
            height++;
            // 取搜索的所有行的最小值
            len = Math.min(len, l);
            // 缩小搜索范围
            h = Math.min(i + len, h);
            w = Math.min(j + len, w);
        }

        // 取长度和高度的最小值作为边长
        len = Math.min(len, height);

        // 边长的平方就是面积
        return len * len;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'1','0','1','1','0','1'},
                {'1','1','1','1','1','1'},
                {'0','1','1','0','1','1'},
                {'1','1','1','0','1','0'},
                {'0','1','1','1','1','1'},
                {'1','1','0','1','1','1'}
        };

        System.out.println(maximalSquare(matrix));
    }
}
