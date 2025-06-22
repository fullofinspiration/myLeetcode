package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0438_AnagramFinder {
    /**
     * 时间复杂度：s.lengh()
     * 空间复杂度:s.length()
     */
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ret = new ArrayList<>();
            int count = p.length();
            Map<Character, Integer> char2Count = new HashMap<>();
            for (char c : p.toCharArray()) {
                handleCount(char2Count, c, 1);
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                handleCount(char2Count, c, -1);
                Integer curCount = char2Count.get(c);
                if (curCount >= 0) {
                    count--;
                }
                int start = i - p.length() + 1;
                if (start < 0) {
                    continue;
                }
                if (count ==0) {
                    ret.add(start);
                }
                char startChar = s.charAt(start);
                handleCount(char2Count, startChar, 1);
                if (char2Count.get(startChar) > 0) {
                     count++;
                }

            }
            return ret;
        }

        private void handleCount(Map<Character, Integer> map2Count, char key, int added) {
            if (!map2Count.containsKey(key)) {
                map2Count.put(key, added);
                return;
            }
            Integer val = map2Count.get(key);
            map2Count.put(key, val + added);
        }
    }
}
