package com.fullofinspiration.github.leetcode;

/**
 * Created by Zhenpeng Zhang on 2021/1/24.
 */
public class _0122StockMaxProfit {
    /**
     * 自己写出来的，我真是太牛逼了
     * 1 f(n) = f(n-1) if prices[i]<prices[i-1]
     * 2 f(n) = f(n-1) + prices[i] if prices[i]-prices[i-1]>0
     * curVal = 0 if f(n)-f(n-1)>0 curVal = f(n)-f(n-1)
     * 总结起来是: f(n) = f(n-1) + curVal
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
    }

    class Solution00 {
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
}
