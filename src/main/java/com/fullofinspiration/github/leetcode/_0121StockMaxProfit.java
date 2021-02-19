package com.fullofinspiration.github.leetcode;

/**
 * 得到股票一天可以赚的最多钱(最大值-最小值)
 * Created by Zhenpeng Zhang on 2021/1/24.
 */
public class _0121StockMaxProfit {

    public static void main(String[] args) {
        _0121StockMaxProfit stockMaxValue = new _0121StockMaxProfit();

        int[] ints = {1, 2, 3};
        int maxEarnAmount = stockMaxValue.getMaxEarnAmount(ints);
        //2
        System.out.println(maxEarnAmount);

        int[] ints1 = {9, 18, 3,4};
        int maxEarnAmount1 = stockMaxValue.getMaxEarnAmount(ints1);
        //9
        System.out.println(maxEarnAmount1);

        int[] ints2 = {9, 18, 3,4,13};
        int maxEarnAmount2 = stockMaxValue.getMaxEarnAmount(ints2);
        //9
        System.out.println(maxEarnAmount2);
    }

    public int getMaxEarnAmount(int[] prices) {
        int curMax = 0;
        int minValue = prices[0];
        for (int index = 1; index < prices.length; index++) {
            int curValue = prices[index];
            if (curValue < minValue) {
                minValue = curValue;
            } else {
                curMax = Math.max(curMax, curValue - minValue);
            }
        }
        return curMax;
    }
}
