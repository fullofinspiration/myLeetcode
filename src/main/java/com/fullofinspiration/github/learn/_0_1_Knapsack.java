package com.fullofinspiration.github.learn;

import java.util.List;

public class _0_1_Knapsack {
    /**
     * 这里写的极其简短，只能说是一个概览类的东西
     * https://leetcode.cn/leetbook/read/2022-qiu-zhao-gao-pin-mian-shi-ti/nkgda7/
     * f(i, j) i为第i件物品，j为当前总重量
     * int cur = 0;
     * if weight(i)<=j {
     * cur =f(i-1,j-weight(cur))+val(cur)
     * }
     * f(i, j)= max(f(i-1,j), cur)
     * return f(i,j)
     * 上面方式只使用了i-1的数组，如果倒序遍历，将空间复杂度从O(m*n)节省到O(n), 其中m为物品数量，n为总重量
     */
    class Solution {
        public int maxWeight(int target, List<Integer> weights, List<Integer> values) {
            int[] rst = new int[target + 1];
            for (int i = 0; i < weights.size(); i++) {
                for (int j = target; j >= 1; j--) {
                    if (j-weights.get(i) >=0) {
                        rst[j] = Math.max(rst[j], rst[j - weights.get(i)] + values.get(i));
                    }
                }
            }
            return rst[target];
        }
    }
}
