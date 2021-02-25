package com.code2020.January;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeeCode123 {

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0;
        // 因为这里是最多不超过两笔交易，所以初始化的时候buy2也要置为 - prices[0]
        int buy2 = 0, sell2 = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(-prices[i], buy1);
            sell1 = Math.max(prices[i] + buy1, sell1);
            buy2 = Math.max(sell1 - prices[i], buy2);
            sell2 = Math.max(buy2 + prices[i], sell2);
        }
        return sell2;
    }
}
