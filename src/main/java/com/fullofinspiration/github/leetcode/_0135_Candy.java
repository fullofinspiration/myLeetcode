package com.fullofinspiration.github.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class _0135_Candy {
    /**
     * https://leetcode.com/problems/candy/solutions/42769/a-simple-solution/comments/41219
     */
    class Solution {
        public int candy(int[] ratings) {
            int[] rst = new int[ratings.length];
            Arrays.fill(rst, 1);
            for (int i = 1; i < rst.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    rst[i] = rst[i - 1] + 1;
                }
            }
            for (int i = rst.length - 1; i > 0; i--) {
                if (ratings[i - 1] > ratings[i]) {
                    rst[i - 1] = Math.max(rst[i - 1], rst[i] + 1);
                }
            }
            return Arrays.stream(rst).sum();
        }
    }
}
