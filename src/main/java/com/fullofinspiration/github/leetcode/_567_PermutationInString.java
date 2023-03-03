package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _567_PermutationInString {
    /**
     * https://leetcode.com/problems/permutation-in-string/solutions/102588/java-solution-sliding-window/?orderBy=most_votes
     */
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length()<s1.length()) {
                return false;
            }
            int[] ints = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                ints[charToInt(s1.charAt(i))]++;
                ints[charToInt(s2.charAt(i))]--;
            }
            if (isAllZero(ints)) {
                return true;
            }
            for (int i = 0, j = s1.length(); j < s2.length(); j++,i++) {
                ints[charToInt(s2.charAt(j))]--;
                ints[charToInt(s2.charAt(i))]++;
                if (isAllZero(ints)) {
                    return true;
                }
            }
            return false;
        }

        private int charToInt(char c) {
            return c - 'a';
        }

        private boolean isAllZero(int[] input) {
            for (int i = 0; i < input.length; i++) {
                if (input[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 1 将数组创建放入到map中，key为character，value为次数
     * 2 判断两个str是否相等：每个key都相等，并且次数都相同
     * 3 每次向右移动时，对左边的次数减1， 对右边的次数加一
     */
    class Solution00 {
        public boolean checkInclusion(String s1, String s2) {
            Map<Character, Integer> expect = convertStringToMap(s1);
            Map<Character, Integer> cur = new HashMap<>(s1.length());
            int low = 0;
            for (int i = 0; i < s2.length(); i++) {
                if (i - low >= s1.length()) {
                    char removedKey = s2.charAt(low);
                    cur.computeIfPresent(removedKey, (a, b) -> b - 1);
                    if (cur.get(removedKey) == 0) {
                        cur.remove(removedKey);
                    }
                    low++;
                }
                char c = s2.charAt(i);
                cur.computeIfPresent(c, (a, b) -> b + 1);
                cur.putIfAbsent(c, 1);
                if (equal(expect, cur)) {
                    return true;
                }
            }
            return false;
        }

        private Map<Character, Integer> convertStringToMap(String s) {
            if (s == null || s.length() == 0) {
                return Collections.emptyMap();
            }
            Map<Character, Integer> all = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char curChar = s.charAt(i);
                if (all.containsKey(curChar)) {
                    all.put(curChar, all.get(curChar) + 1);
                    continue;
                }
                all.put(curChar, 1);
            }
            return all;
        }

        private boolean equal(Map<Character, Integer> first, Map<Character, Integer> second) {
            if (first.size() != second.size()) {
                return false;
            }
            for (Map.Entry<Character, Integer> cur : first.entrySet()) {
                Character key = cur.getKey();
                Integer value = cur.getValue();
                if (!second.containsKey(key) || !value.equals(second.get(key))) {
                    return false;
                }
            }
            return true;
        }
    }
}
