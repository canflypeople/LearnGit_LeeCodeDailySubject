package com.December;

import java.util.Arrays;
import java.util.Map;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class LeeCode714 {

    /**
     * 贪心算法:当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
     * 动态规划：。。。
     * dp[i][2] dp[i][0]表示当前没有股票，dp[i][1]表示当前有股票
     * dp[i][0] = max(prices[i] - dp[i - 1][1] - 2, dp[i - 1][0])
     * dp[i][1] = max(-prices[i] + dp[i - 1][0], dp[i - 1][1])
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        /*int n = prices.length;
        int[][] dp = new int[n][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(prices[i] + dp[i - 1][1] - fee, dp[i - 1][0]);
            dp[i][1] = Math.max(-prices[i] + dp[i - 1][0], dp[i - 1][1]);
        }
        return dp[n - 1][0];*/
        int profit = 0, buyPrice = prices[0] + fee;
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i] + fee) {
                buyPrice = prices[i] + fee;
            } else if (buyPrice < prices[i]) {
                profit += prices[i] - buyPrice;
                buyPrice = prices[i];
            }
        }
        return profit;


    }

    /**
     * 121. 买卖股票的最佳时机
     *     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     *     如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     *     注意：你不能在买入股票前卖出股票。
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        // 贪心算法，就是需要算出元素间的最大值
        int profit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }



    /**
     * 53. 最大子序和
     *     给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (preSum < 0) {
                preSum = 0;
            }
            if (num > 0) {
                preSum += num;
                maxSum = Math.max(preSum, maxSum);
            } else {
                preSum += num;
                maxSum = Math.max(maxSum, num);
            }
        }
        return maxSum;

    }






}
