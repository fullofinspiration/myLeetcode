package com.fullofinspiration.github.leetcode;


/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/24 6:44 PM
 */
public class _1049_Weight4LastStone {

  class Solution {

    public int lastStoneWeightII(int[] stones) {
      if (stones == null || stones.length == 0) {
        return 0;
      }
      int totalWeight = 0;
      for (int weight : stones) {
        totalWeight += weight;
      }
      int curMax = 0;
      boolean[] allValues = new boolean[totalWeight / 2 + 1];
      allValues[0] = true;
      for (int weight : stones) {
        for (int idx = allValues.length - 1; idx > 0; idx--) {
          if (allValues[idx] || (idx >= weight && allValues[idx - weight])) {
            allValues[idx] = true;
            curMax = Math.max(curMax, idx);

          }
        }
      }
      return totalWeight - 2 * curMax;
    }
  }

}
