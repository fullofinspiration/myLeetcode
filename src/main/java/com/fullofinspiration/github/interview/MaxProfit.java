package com.fullofinspiration.github.interview;

/**
 * i 第i件东西
 * j 总成本
 * f(i,j) = max{f(i-1,j), f(i-1,j-costs[i])+ profit[i]}
 */
public class MaxProfit {
  public int getMaxProfit(int[] costs, int[] sells, int total) {

     return doGetMaxProfit(costs, sells, total);
  }
  private int doGetMaxProfit(int[] costs, int[] sells, int total) {
    int[] rst = new int[total];
    for (int i = 0; i < costs.length; i++) {
      for (int j = total - 1; j >= 0; j--) {
        if (j - costs[i] >= 0) {
          rst[j] = Math.max(rst[j], sells[i] + rst[j - costs[i]]);
        }
      }
    }
    return rst[costs.length - 1];
  }
}
