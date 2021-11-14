package com.fullofinspiration.github.leetcode;

import java.util.Arrays;

public class _0727_MinimumWindowSubsequence {
    class Solution {
        public String minWindow(String str, String target) {
            if (target == null || target.length() == 0) {
                return "";
            }
            if (str == null || str.length() == 0) {
                return "";
            }
            int[][] candidate = new int[2][str.length()];
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == target.charAt(0)) {
                    candidate[0][i] = i;
                } else {
                    candidate[0][i] = -1;
                }
            }
            System.out.println(Arrays.toString(candidate[0]));
            for (int i = 1; i < target.length(); i++) {
                Arrays.fill(candidate[i & 1], -1);
                int preQualifiedIdx = -1;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == target.charAt(i) && preQualifiedIdx != -1) {
                        candidate[i & 1][j] = preQualifiedIdx;
                    }
                    int preStartRowIdx = (~i) & 1;
                    int preStartIdx = candidate[preStartRowIdx][j];
                    System.out.printf("i: %s,Row: %s, col: %s, val: %s%n", i, preStartRowIdx, j, preStartIdx);
                    if (preStartIdx != -1) {
                        preQualifiedIdx = preStartIdx;
                    }
                }
                int rowIdx = i & 1;
                System.out.println(Arrays.toString(candidate[rowIdx]));
            }
            int start = -1;
            int end = -1;
            for (int i = candidate[0].length - 1; i >= 0; i--) {
                int idx = (target.length() - 1) & 1;
                if (candidate[idx][i] != -1 &&
                        (start == -1 || i - candidate[idx][i] + 1 <= end - start + 1)) {
                    end = i;
                    start = candidate[idx][i];
                }
            }
            if (start == -1) {
                return "";
            }
            return str.substring(start, end + 1);
        }
    }
}
