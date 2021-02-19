package com.fullofinspiration.github.leetcode;

/**
 * Created by Zhenpeng Zhang on 2021/1/24.
 */
public class _0122StockMaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int previousQuote = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int todayProfit = prices[i] - previousQuote;
            if (todayProfit > 0) {
                maxProfit += todayProfit;
            }
            previousQuote = prices[i];
        }
        return maxProfit;
    }
}
