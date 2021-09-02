package com.fullofinspiration.github.leetcode;

public class _0718_MaximumLengthOfRepeatedSubArray {
    //https://leetcode.com/problems/maximum-length-of-repeated-subarray/discuss/109039/Concise-Java-DP%3A-Same-idea-of-Longest-Common-Substringooz
    class Solution {
        public int findLength(int[] a, int[] b) {
            if (a == null || b == null) {
                return 0;
            }
            int[][] ints = new int[a.length + 1][b.length + 1];
            int max = 0;
            for (int i = 1; i <= a.length; i++) {
                for (int j = 1; j <= b.length; j++) {
                    if (a[i - 1] == b[j - 1]) {
                        ints[i][j] = ints[i - 1][j - 1] + 1;
                        max = Math.max(ints[i][j], max);
                    }
                }
            }
            return max;
        }
    }
}
