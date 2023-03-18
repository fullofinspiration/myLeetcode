package com.fullofinspiration.github.leetcode;

import java.util.Arrays;

public class _0455_AssignCookies {
    /**
     * 自己写出来的，但是我看不出来这道题的考察点是什么
     * 先排序 时间复杂度O(nlogn) 空间复杂度O(n)
     * 遇到第一个满足的+1，
     * 返回g的末尾索引+1
     */
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            for (int j = 0; i < g.length && j < s.length; j++) {
                if (s[j] >= g[i]) {
                    i++;
                }
            }
            return i;
        }
    }
}
