package com.silentao.leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 买卖股票系列
 * @Author Silence
 * @Date 2020/8/1 9:04
 **/
public class BestTimeTransactionStock {

    /**
     * 121. 买卖股票的最佳时机
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) {
            return 0;
        }

        int min = prices[0], res = 0;
        // 选出一个最小的元素再和后面的元素相减
        // 取差最大的值就是卖出的最大价值
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);

            res = Math.max(res, prices[i] - min);
        }

        return res;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 尽可能多的交易
     * 贪心算法，只要能赚钱，就交易
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * @param prices
     * @return
     */
    public int maxProfitMore(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] < prices[i]) {
                // prices[i - 1] < prices[i]就交易
                res += prices[i] - prices[i - 1];
            }
        }

        return res;
    }

    /**
     * 309. 最佳买卖股票时机含冷冻期
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     * @param prices
     * @return
     */
    public int maxProfitCoolDown(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        Map<Integer, Integer> memory = new HashMap<>();
        return maxProfitCoolDown(prices, 0, memory);
    }

    private int maxProfitCoolDown(int[] prices, int day, Map<Integer, Integer> memory) {
        if (day >= prices.length) {
            return 0;
        }

        if (memory.containsKey(day)) {
            return memory.get(day);
        }

        int res = 0;
        int min = prices[day];
        for (int sell = day + 1; sell < prices.length; sell++) {
            min = Math.min(min, prices[sell]);

            res = Math.max(res , prices[sell] - min + maxProfitCoolDown(prices, sell + 2, memory));
        }

        memory.put(day, res);

        return res;
    }
}
