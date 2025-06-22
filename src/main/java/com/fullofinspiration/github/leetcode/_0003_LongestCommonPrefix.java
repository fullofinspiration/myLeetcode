package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;


public class _0003_LongestCommonPrefix {
    class Solution {
        Map<Character, Integer> char2Count = new HashMap<>();

        public int lengthOfLongestSubstring(String s) {
            int dupliCount = 0;
            int start = 0, end = 0;
            int maxLen = 0;
            for (; end < s.length(); end++) {
                char cur = s.charAt(end);
                handleCount(cur, 1);
                int count = char2Count.get(cur);
                if (count == 2) {
                    dupliCount++;
                }
                if (dupliCount == 0) {
                    int curLen = end - start + 1;
                    maxLen = Math.max(maxLen, curLen);
                    continue;
                }

                for (; dupliCount > 0; start++) {
                    char startChar = s.charAt(start);
                    handleCount(startChar, -1);
                    int startCount = char2Count.get(startChar);
                    if (startCount == 1) {
                        dupliCount--;
                    }
                }
            }
            return maxLen;
        }

        private void handleCount(char key, int added) {
            if (!char2Count.containsKey(key)) {
                char2Count.put(key, added);
                return;
            }
            Integer val = char2Count.get(key);
            char2Count.put(key, val + added);
        }
    }

    /**
     * 1)连续的 2)不重复的，故保存三个数据：
     * 1 用hashmap保存当前遍历时所有元素key2Index，如果元素相同时，保存索引最大的值
     * 2 保存之前最大长度
     * 3 保存当前正在遍历的不重复的低点索引值，
     * 最终通过遍历可以得到最终最长不重复子串长度
     * <p>
     * medium
     */
    class Solution03 {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> char2Idx = new HashMap<>();
            int max = 0;
            int curLow = 0;
            for (int i = 0; i < s.length(); i++) {
                if (char2Idx.containsKey(s.charAt(i)) && char2Idx.get(s.charAt(i)) >= curLow) {
                    curLow = char2Idx.get((s.charAt(i))) + 1;
                } else {
                    int cur = i - curLow + 1;
                    max = Math.max(max, cur);
                }
                char2Idx.put(s.charAt(i), i);
            }
            return max;
        }
    }

    /**
     * 第二次写，比上一次的方法更简洁
     */
    class Solution02 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> char2Index = new HashMap<>();
            int max = 0;
            int curLength = 0;
            for (int i = 0; i < s.length(); i++) {
                char curValue = s.charAt(i);
                if (!char2Index.containsKey(curValue) || char2Index.get(curValue) < i - curLength) {
                    curLength++;
                    if (curLength > max) {
                        max = curLength;
                    }
                } else {
                    curLength = i - char2Index.get(curValue);
                }
                char2Index.put(curValue, i);
            }
            return max;
        }
    }


    class Solution01 {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            HashMap<Character, Integer> val2Index = new HashMap<>();
            int prevMaxLength = 0;
            int curLowIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                char curVal = s.charAt(i);
                if (val2Index.containsKey(curVal) && val2Index.get(curVal) >= curLowIndex) {
                    curLowIndex = val2Index.get(curVal) + 1;
                    val2Index.put(curVal, i);
                    continue;
                }
                val2Index.put(curVal, i);
                int curLength = i - curLowIndex + 1;
                if (curLength > prevMaxLength) {
                    prevMaxLength = curLength;
                }
            }
            return prevMaxLength;
        }
    }

    /**
     * 2021.1.23 写的，实现有点复杂
     */
    class Solution00 {
        /**
         * 只需要保存是否有出现过的元素，同时和旧的最大值相对比
         */
        public int lengthOfLongestSubString(String str) {
            Map<Character, Integer> all = new HashMap<>();
            int maxLength = 0;
            int curStart = 0;
            if (str == null || str.length() == 0) {
                return 0;
            }
            for (int index = 0; index < str.length(); index++) {
                char curChar = str.charAt(index);
                if (all.containsKey(curChar) && curStart <= all.get(curChar)) {
                    curStart = all.get(curChar) + 1;
                }
                maxLength = Math.max(maxLength, index - curStart + 1);
                all.put(curChar, index);
            }
            return maxLength;
        }
    }
}