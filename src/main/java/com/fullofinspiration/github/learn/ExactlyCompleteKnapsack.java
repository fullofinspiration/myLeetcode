package com.fullofinspiration.github.learn;

import java.util.Arrays;
import java.util.List;

/**
 * 完全背包问题，要求刚好等于该数量，否则返回-1
 */
public class ExactlyCompleteKnapsack {
    /**
     * f(i,j) i: 前i个物品 j 书包总容量
     * f(i,j) =max(f(i-1,j), f(i,j-weight)+values[i])
     */
    class Solution {
        public int maxWeight(int target, List<Integer> weights, List<Integer> values) {
            int[] rst = new int[target + 1];
            Arrays.fill(rst, -1);
            rst[0] = 0;
            for (int i = 0; i < weights.size(); i++) {
                for (int j = 1; j <= target; j++) {
                    int idx = j - weights.get(i);
                    if (idx >= 0 && rst[idx] != -1) {
                        rst[j] = Math.max(rst[j], rst[idx] + values.get(i));
                    }
                }
            }
            return rst[target];
        }
    }

}
