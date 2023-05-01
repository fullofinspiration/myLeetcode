package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0049_GroupAnagrams {
    /**
     * https://leetcode.com/problems/group-anagrams/solutions/19176/share-my-short-java-solution/
     * 错误1：笔误应该是！containsKey才加入，开始写反了
     */
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) {
                return Collections.emptyList();
            }
            Map<String, List<String>> all = new HashMap<>();
            for (String s : strs) {
                char[] chars = new char[26];
                for (char c : s.toCharArray()) {
                    chars[c - 'a']++;
                }
                String key = String.valueOf(chars);
                if (!all.containsKey(key)) {
                    all.put(key, new ArrayList<>());
                }
                all.get(key).add(s);
            }
            return new ArrayList<>(all.values());
        }
    }
}
