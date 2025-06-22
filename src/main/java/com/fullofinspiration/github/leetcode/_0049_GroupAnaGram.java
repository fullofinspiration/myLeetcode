package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0049_GroupAnaGram {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> rets = new HashMap<>();
            for (String cur : strs) {
                char[] charArray = cur.toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);
                if (rets.containsKey(key)) {
                    rets.get(key).add(cur);
                    continue;
                }
                List<String> list = new ArrayList<>();
                list.add(cur);
                rets.put(key, list);
            }

            return new ArrayList<>(rets.values());
        }
    }
}
