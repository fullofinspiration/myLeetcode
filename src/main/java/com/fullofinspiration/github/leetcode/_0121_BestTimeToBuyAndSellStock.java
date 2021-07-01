package com.fullofinspiration.github.leetcode;

/**
 * if  (prices == null || prices.length == 0) {
 *     return 0;
 * }
 * int oldLow = 0,oldHigh = 0, newLow = 0;
 * for (int i=0;i< prices.length;prices++) {
 *    if(prices[i] < oldLow){
 *        newLow = prices[i];
 *    } else if (prices[i] - newLow > oldHigh-oldLow) {
 *        oldLow = newLow;
 *        oldHigh = prices[i];
 *    }
 * }
 * return oldHigh  - oldLow;
 */
public class _0121_BestTimeToBuyAndSellStock {
}
