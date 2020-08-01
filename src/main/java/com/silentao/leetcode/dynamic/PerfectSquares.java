package com.silentao.leetcode.dynamic;

import java.util.Arrays;

/**
 * @Description
 * https://leetcode-cn.com/problems/perfect-squares/
 * 279. 完全平方数
 * @Author Silence
 * @Date 2020/8/1 10:18
 **/
public class PerfectSquares {

    /**
     * 超时
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int res = Integer.MAX_VALUE;
        if (n == 0) {
            return 0;
        }

        int mid = (n + 1) / 2;
        for (int i = mid; i >= 1; i--) {
            int temp = i * i;
            if (temp > n) {
                continue ;
            }

            res = Math.min(res, numSquares(n - temp) + 1);
        }

        return res;
    }

    /**
     * 动态规划解法
     * 要求numSquares(n)，那么就把numSquares([1, n])求出来
     * 避免重复计算
     * 用dp数组保存结果
     * @param n
     * @return
     */
    public static int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 算出n的平方根+1
        // 然后构建[1, sqrt]的平方序列
        // n的完全平方和就从这里取
        // 避免了重复计算
        int sqrt = (int) Math.sqrt(n) + 1;
        // 平方序列
        int[] squares = new int[sqrt + 1];
        for (int i = 1; i <= sqrt; i++) {
            squares[i] = i * i;
        }

        dp[0] = 0;
        // dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sqrt; j++) {
                if (i < squares[j]) {
                    break ;
                }

                // numSquares(n) = min(numSquares(n), numSquares(n-k) + 1)
                dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(1));
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquaresDP(53));
    }
}
