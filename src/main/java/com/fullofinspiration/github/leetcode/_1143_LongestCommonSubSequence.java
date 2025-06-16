package com.fullofinspiration.github.leetcode;

public class _1143_LongestCommonSubSequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] ret = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 1; i < text1.length() + 1; i++) {
                for (int j = 1; j < text2.length() + 1; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        ret[i][j] = ret[i - 1][j - 1]+1;
                        continue;
                    }
                    ret[i][j] = Math.max(ret[i - 1][j], ret[i][j - 1]);
                }
            }
            return ret[text1.length()][text2.length()];
        }
    }

    class Solution01 {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length() + 1;
            int n = text2.length() + 1;
            int[][] nums = new int[m][n];
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        nums[i][j] = nums[i - 1][j - 1] + 1;
                    } else {
                        nums[i][j] = Math.max(nums[i][j - 1], nums[i - 1][j]);
                    }
                }
            }
            return nums[m - 1][n - 1];
        }
    }

    class Solution00 {
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
