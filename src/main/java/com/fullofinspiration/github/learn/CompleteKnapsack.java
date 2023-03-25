package com.fullofinspiration.github.learn;

import java.util.List;

public class CompleteKnapsack {
    /**
     * f(i,j) i: 前i个物品 j 书包总容量
     * f(i,j) =max(f(i-1,j), f(i,j-weight)+values[i])
     */
    class Solution {
        public int maxWeight(int target, List<Integer> weights, List<Integer> values) {
            int[] rst = new int[target + 1];
            for (int i = 0; i < weights.size(); i++) {
                for (int j = 1; j <= target; j++) {
                    if (j - weights.get(i) >= 0) {
                        rst[j] = Math.max(rst[j], rst[j - weights.get(i)] + values.get(i));
                    }
                }
            }
            return rst[target];
        }
    }
}
