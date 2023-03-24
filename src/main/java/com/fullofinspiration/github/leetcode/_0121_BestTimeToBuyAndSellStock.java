package com.fullofinspiration.github.leetcode;

public class _0121_BestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int preMax = 0;
            int curLow = prices[0];
            for (int i = 1; i < prices.length; i++) {
                preMax = Math.max(preMax, prices[i] - curLow);
                curLow = Math.min(curLow, prices[i]);
            }
            return preMax;
        }
    }

    /**
     * if  (prices == null || prices.length == 0) {
     * return 0;
     * }
     * int oldLow = 0,oldHigh = 0, newLow = 0;
     * for (int i=0;i< prices.length;prices++) {
     * if(prices[i] < oldLow){
     * newLow = prices[i];
     * } else if (prices[i] - newLow > oldHigh-oldLow) {
     * oldLow = newLow;
     * oldHigh = prices[i];
     * }
     * }
     * return oldHigh  - oldLow;
     */
    class Solution00 {
        public int maxProfit(int[] prices) {
            return 0;
        }
    }
}
