package com.fullofinspiration.github.leetcode;

/**
 * Created by Zhenpeng Zhang on 2021/3/4.
 */
public class _0008String2Integer {
    class Solution {
        public int myAtoi(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            long value = 0;
            int flag = 1;
            int index = 0;
            while (index < s.length() && s.charAt(index) == ' ') {
                index++;
            }
            if (index == s.length()) {
                return 0;
            }
            if (s.charAt(index) == '-') {
                flag = -1;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }
            while (index < s.length()) {
                if (s.charAt(index) < '0' || s.charAt(index) > '9') {
                    break;
                }
                value = value * 10 + (s.charAt(index) - '0');
                if (flag == 1 && value > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (flag == -1 && -value < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                index++;
            }
            return (int) value * flag;
        }
    }
}
