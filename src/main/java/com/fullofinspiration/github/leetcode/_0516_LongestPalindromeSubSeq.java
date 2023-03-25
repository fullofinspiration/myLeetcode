package com.fullofinspiration.github.leetcode;

public class _0516_LongestPalindromeSubSeq {
    /**
     * https://leetcode.com/problems/longest-palindromic-subsequence/solutions/99101/straight-forward-java-dp-solution/?orderBy=most_votes
     * f(i,j) 区间i到j回文最大长度
     * 初始化: f(i,i)=1
     * f(i,j) = f(i+1, j-1) + 2 if s[i]==s[j]
     * f(i,j) =max( f(i+1, j), f(i,j-1))
     * i:n-1...0
     * j:0...n-1
     */
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int rst[][] = new int[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                rst[i][i] = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        rst[i][j] = rst[i + 1][j - 1] + 2;
                    } else {
                        rst[i][j] = Math.max(rst[i + 1][j], rst[i][j - 1]);
                    }
                }
            }
            return rst[0][s.length() - 1];
        }
    }
}
