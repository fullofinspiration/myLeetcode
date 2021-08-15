package com.fullofinspiration.github.leetcode;

import java.util.HashMap;

/**
 * 1)连续的 2)不重复的，故保存三个数据：
 * 1 用hashmap保存当前遍历时所有元素key2Index，如果元素相同时，保存索引最大的值
 * 2 保存之前最大长度
 * 3 保存当前正在遍历的不重复的低点索引值，
 * 最终通过遍历可以得到最终最长不重复子串长度
 *
 * medium
 */
public class _0003_LongestCommonPrefix {

    class Solution {
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
}
