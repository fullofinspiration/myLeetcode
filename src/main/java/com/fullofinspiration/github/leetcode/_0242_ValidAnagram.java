package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0242_ValidAnagram {
    /**
     * 再solution01基础上进行优化
     * 优化点：
     * 1 之前遍历有多余变量i，导致代码臃肿，这里通过s.toCharArray的方式遍历变量，去掉i变量，使得代码简洁，不易出错
     * 2 减少一次遍历：减少最后遍历hashmap时间，通过第二次遍历时判断是否等于0，同时需要增加判断两个数组长度是否相等，
     * 否则会导致遍历第二个数组，没有完全遍历hashmap的情况出现
     *
     */
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> char2Frequency = new HashMap<>();
            for (char c : s.toCharArray()) {
                Integer frequency = char2Frequency.getOrDefault(c, 0);
                char2Frequency.put(c, frequency + 1);
            }
            for (char c : t.toCharArray()) {
                Integer frequency = char2Frequency.getOrDefault(c, 0);
                if (0 == frequency) {
                    return false;
                }
                char2Frequency.put(c, frequency - 1);
            }
            return true;
        }
    }

    /**
     * 没有一次通过，错误原因：不够仔细，第二个变量是t，我仍然写的s，这种在写之前应该注意哪些地方比较容易出错：
     * 1 先写computeIfPresent,再写putIfAbsent，如果顺序写反，会导致数量错误的加两次
     * 2 有过多样板代码，臃肿代码导致分心，不能专心注意这些易出错的地方，后续还有熟练写这种方法，或者找到更简洁的书写方式
     */
    class Solution01 {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> char2Frequency = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char2Frequency.computeIfPresent(s.charAt(i), (a, b) -> b + 1);
                char2Frequency.putIfAbsent(s.charAt(i), 1);
            }
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                char2Frequency.computeIfPresent(c, (key, curVal) -> curVal - 1);
                char2Frequency.putIfAbsent(c, -1);
            }
            for (Map.Entry<Character, Integer> entry : char2Frequency.entrySet()) {
                if (entry.getValue() != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 方法1（由于只包含小写字母，故数量固定，而且编码是连续的，
     * 可以通过数组idx代表某个具体字母，数组中值代表出现次数） ：
     * 1 新建数组
     * 2 遍历string1，如果有数量加1
     * 3 遍历string2， 如果有数量减1
     * 4 看数组元素是否等于0，若等于0，代表是anagram
     * 方法2 使用mashmap
     * 1 新建hashmap，key是值，value是出现次数
     * 2 遍历s
     * 3 遍历t
     * 4 遍历hashmap，如果均为0，则代表互为异位词
     */
    class Solution00 {
        public boolean isAnagram(String s, String t) {
            int[] frequencies = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int idx = c - 'a';
                frequencies[idx]++;
            }
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                int idx = c - 'a';
                frequencies[idx]--;
            }
            for (int frequency : frequencies) {
                if (frequency != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
