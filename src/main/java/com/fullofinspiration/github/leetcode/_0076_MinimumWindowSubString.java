package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0076_MinimumWindowSubString {
    public class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> char2Count = new HashMap<>();
            for (char c : t.toCharArray()) {
                handleCount(char2Count, c, 1);
            }
            int start = 0, end = 0, total = t.length();
            int minLen = Integer.MAX_VALUE, targetStartIdx = -1;
            while (end < s.length()) {
                char c = s.charAt(end);
                handleCount(char2Count, c, -1);
                if (char2Count.get(c) >= 0) {
                    total--;
                }
                end++;
                while (total == 0) {
                    int len = end - start;
                    if (len < minLen) {
                        minLen = len;
                        targetStartIdx = start;
                    }
                    c = s.charAt(start);
                    handleCount(char2Count, c, 1);
                    if (char2Count.get(c) > 0) {
                        total++;
                    }
                    start++;
                }
            }
            if (minLen == Integer.MAX_VALUE) {
                return "";
            }
            return s.substring(targetStartIdx, targetStartIdx + minLen);

        }

        private void handleCount(Map<Character, Integer> map, char key, int added) {
            if (!map.containsKey(key)) {
                map.put(key, added);
                return;
            }
            Integer count = map.get(key);
            map.put(key, count + added);
        }
    }

    /**
     * @see _0076_MinimumWindowSubString.Solution00
     * 参照这个实现的各种补丁的版本
     */
    public class Solution01 {
        public String minWindow(String s, String t) {
            Map<Character, Integer> char2Count = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char cur = t.charAt(i);
                handleCount(char2Count, cur, 1);
            }
            int totalCount = t.length(), minCount = Integer.MAX_VALUE, targetLow = -1, targetHigh = -1;
            int low = 0, high = -1;
            while (++high < s.length()) {
                char c = s.charAt(high);
                if (!char2Count.containsKey(c)) {
                    continue;
                }
                handleCount(char2Count, c, -1);
                Integer count = char2Count.get(c);
                if (count >= 0) {
                    totalCount--;
                }
                if (totalCount > 0) {
                    continue;
                }
                int curLen = high - low + 1;
                if (curLen < minCount) {
                    minCount = curLen;
                    targetLow = low;
                    targetHigh = high;
                }
                if (low == high) {
                    break;
                }
                low++;
                while (low <= high) {

                    char lowChar = s.charAt(low - 1);
                    if (char2Count.containsKey(lowChar)) {
                        handleCount(char2Count, lowChar, 1);
                        int curCount = char2Count.get(lowChar);
                        if (curCount > 0) {
                            totalCount++;
                            break;
                        }
                    }
                    curLen = high - low + 1;
                    if (curLen < minCount) {
                        minCount = curLen;
                        targetLow = low;
                        targetHigh = high;
                    }
                    if (low == high) {
                        break;
                    } else {
                        low++;
                    }
                }
            }
            if (minCount != Integer.MAX_VALUE) {
                return s.substring(targetLow, targetHigh + 1);
            }
            return "";
        }

        private void handleCount(Map<Character, Integer> map, char key, int added) {
            if (!map.containsKey(key)) {
                map.put(key, added);
                return;
            }
            Integer count = map.get(key);
            map.put(key, count + added);
        }
    }

    /**
     * https://leetcode.com/problems/minimum-window-substring/solutions/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
     * 这不是我实现的，只是用豆包翻译了上面链接的c++代码
     */
    public class Solution00 {
        public String minWindow(String s, String t) {
            // 统计t中字符出现的次数
            Map<Character, Integer> map = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // counter表示还需要找到的t中字符的总数
            int start = 0, end = 0, counter = t.length();
            int minStart = 0, minLen = Integer.MAX_VALUE;
            int size = s.length();

            // 移动end指针寻找有效窗口
            while (end < size) {
                char endChar = s.charAt(end);
                // 如果当前字符在t中存在，减少counter计数
                if (map.getOrDefault(endChar, 0) > 0) {
                    counter--;
                }
                // 减少map中对应字符的计数（不存在于t中的字符会变为负值）
                map.put(endChar, map.getOrDefault(endChar, 0) - 1);
                end++;

                // 当找到有效窗口时，移动start指针寻找更小的窗口
                while (counter == 0) {
                    if (end - start < minLen) {
                        minStart = start;
                        minLen = end - start;
                    }

                    char startChar = s.charAt(start);
                    map.put(startChar, map.getOrDefault(startChar, 0) + 1);
                    // 如果字符在t中存在，增加counter计数
                    if (map.get(startChar) > 0) {
                        counter++;
                    }
                    start++;
                }
            }

            if (minLen != Integer.MAX_VALUE) {
                return s.substring(minStart, minStart + minLen);
            }
            return "";
        }
    }
}
