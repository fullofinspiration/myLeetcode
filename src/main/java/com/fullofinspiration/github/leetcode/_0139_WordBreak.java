package com.fullofinspiration.github.leetcode;

import java.util.List;

public class _0139_WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] satisfies = new boolean[s.length() + 1];
            satisfies[0] = true;
            for (int i = 1; i < satisfies.length; i++) {
                for (String word : wordDict) {
                    if (i < word.length()) {
                        continue;
                    }
                    String substring = s.substring(i - word.length(), i);
                    if (substring.equals(word)&& satisfies[i-word.length()]) {
                        satisfies[i]=true;
                        break;
                    }
                }
            }
            return satisfies[satisfies.length - 1];
        }
    }

    /**
     * s从1遍历到s.length:
     * 遍历wordDict，任意一个为true则为true，否则为false fn= any (fn-s1) (fn-s2) is true
     */
    class Solution00 {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] rst = new boolean[s.length() + 1];
            rst[0] = true;
            for (int i = 1; i < rst.length; i++) {
                for (String word : wordDict) {
                    if (i < word.length()) {
                        continue;
                    }
                    String substring = s.substring(i - word.length(), i);
                    if (substring.equals(word) && rst[i - word.length()]) {
                        rst[i] = true;
                        break;
                    }
                }
            }
            return rst[rst.length - 1];
        }
    }
}
