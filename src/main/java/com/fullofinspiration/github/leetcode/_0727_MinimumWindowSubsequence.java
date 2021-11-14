package com.fullofinspiration.github.leetcode;

import java.util.Arrays;

/**
 * 一 f(n)为(start, end)的列表，对于每个start，end满足：
 * 1 S[start] = target[0], S[end] = target[n]
 * 2 每个start对应一个end，该end值使得[start,end]长度最小
 * 3 每个end只会对应一个start，该start保证[start, end]长度最小
 * 所以如果有满足条件的数据存在，一个start只会对对应一个end，一个end只会对应一个start,故每次遍历后，f(n)中的start和end的值都是不同的
 * 二 已知f(n),求f(n+1)的方式:
 * 遍历S，若S[i] = target[i],且在f(n)中选取preEnd最大的值对应的(preStart, preEnd)，然后新增(start, end), start=preStart, end = i
 * 遍历S时:如何找到(preStart, preEnd):
 * 索引从小到大遍历遍历candidate，索引大的值对应的preStart一定大于索引小的值对应的preStart，这样可以保证每次只遍历一次，对于每个i，都能一下子得到满足条件的candidate
 */
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
//            System.out.println(Arrays.toString(candidate[0]));
            for (int i = 1; i < target.length(); i++) {
                Arrays.fill(candidate[i & 1], -1);
                int preQualifiedIdx = -1;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == target.charAt(i) && preQualifiedIdx != -1) {
                        candidate[i & 1][j] = preQualifiedIdx;
                    }
                    int preStartRowIdx = (~i) & 1;
                    int preStartIdx = candidate[preStartRowIdx][j];
//                    System.out.printf("i: %s,Row: %s, col: %s, val: %s%n", i, preStartRowIdx, j, preStartIdx);
                    if (preStartIdx != -1) {
                        preQualifiedIdx = preStartIdx;
                    }
                }
                int rowIdx = i & 1;
//                System.out.println(Arrays.toString(candidate[rowIdx]));
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
