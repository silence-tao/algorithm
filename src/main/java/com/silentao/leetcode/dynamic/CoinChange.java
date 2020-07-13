package com.silentao.leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * @Author Silence
 * @Date 2020/7/13 22:14
 **/
public class CoinChange {

    /**
     * 暴力法，超出时间限制
     * 直接一个一个试，然后比较每次结果取最小值
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange1(int[] coins, int amount) {
        // 兑换成功直接返回0
        if (amount == 0) {
            return 0;
        }

        int time = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int left;
            if ((left = amount - coins[i]) < 0) {
                continue ;
            }

            // 使用了coins[i]，left需要的硬币数
            int res = coinChange1(coins, left);
            // res == -1 表示没有这种兑换法
            if (res != -1) {
                // res + 1 表示当前使用了coins[i]，所以+1
                // 并取最小值
                time = Math.min(time, res + 1);
            }
        }

        return time == Integer.MAX_VALUE ? -1 : time;
    }


    /**
     * 带备忘录的解法
     * 就是在暴力法的基础上加了个备忘录
     * 直接一个一个试，然后比较每次结果取最小值
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }

        Map<Integer, Integer> memory = new HashMap<>();

        return coinChange(coins, amount, memory);
    }

    /**
     * 一个个试硬币，然后取最小值
     * 并把结果记录到备忘录里
     * @param coins
     * @param amount
     * @param memory 备忘录
     * @return
     */
    private static int coinChange(int[] coins, int amount,
                                  Map<Integer, Integer> memory) {
        // 兑换成功直接返回0
        if (amount == 0) {
            return 0;
        }

        if (memory.containsKey(amount)) {
            // 备忘录里有，直接返回
            return memory.get(amount);
        }

        int time = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int left;
            if ((left = amount - coins[i]) < 0) {
                continue ;
            }

            int res = coinChange(coins, left, memory);
            if (res != -1) {
                time = Math.min(time, res + 1);
            }
        }

        int ans = time == Integer.MAX_VALUE ? -1 : time;
        // 将结果放入备忘录
        memory.put(amount, ans);

        return ans;
    }

    /**
     * 动态规划法
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChangeDP(int[] coins, int amount) {
        // 用来保存需要兑换[1, amount]元钱分别最少需要几个硬币
        int[] dp = new int[amount + 1];
        // 先把所有的都标记为不可能的组合
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // 凑齐0元需要0个硬币
        dp[0] = 0;

        // 自底向上，先计算出兑换最少钱数需要的硬币数
        // 然后再逐步计算出兑换amount需要的硬币数
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 兑换了硬币coin后，还剩余的钱数
                int lave;
                if ((lave = i - coin) < 0) {
                    continue ;
                }

                // 取当前钱数需要的硬币数和剩余钱数需要的硬币数+1的最小值
                dp[i] = Math.min(dp[i], dp[lave] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange1(coins, amount));
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChangeDP(coins, amount));
    }
}
