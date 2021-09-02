package com.fullofinspiration.github.leetcode;

public class _1143_LongestCommonSubSequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            if (text1 == null || text2 == null) {
                return 0;
            }
            int[][] ints = new int[text1.length() + 1][text2.length() + 1];
            int max = 0;
            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        ints[i][j] = ints[i - 1][j - 1] + 1;
                    } else {
                        ints[i][j] = Math.max(ints[i - 1][j], ints[i][j - 1]);
                    }
                    if (ints[i][j] > max) {
                        max = ints[i][j];
                    }
                }
            }
            return max;
        }
    }
}
