package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0279_NumsSquares {
    /**
     * 1 取Sqrt(n)
     * 2 square(1), square(2)...square(x) candidates
     * 3 mins[] = new int[n+1]
     * 4 for int i: n {
     * int min = Integer.MAX_VALUE
     * for (candidate:candidates) {
     * if (i-candidate>=0 && mins[i-candidate]!=Integer.MAX_VALUE) {
     * mins[i] = min(min, mins[i-candidate]+1)
     * }
     * }
     * }
     * 5 return mins[n]
     */
    class Solution {
        public int numSquares(int n) {
            int val = (int) Math.sqrt(n);
            List<Integer> candidates = new ArrayList<>(val);
            for (int i = 1; i <= val; i++) {
                candidates.add((int) Math.pow(i, 2));
            }
            int[] mins = new int[n + 1];
            Arrays.fill(mins, Integer.MAX_VALUE);
            mins[0] = 0;
            for (int i = 1; i <= n; i++) {
                int min = mins[i];
                for (int candidate : candidates) {
                    if (i - candidate >= 0 && mins[i - candidate] != Integer.MAX_VALUE) {
                        min = Math.min(min, mins[i - candidate] + 1);
                    }
                }
                mins[i] = min;
            }
            return mins[n];
        }
    }
}
