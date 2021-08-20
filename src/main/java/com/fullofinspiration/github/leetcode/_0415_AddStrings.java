package com.fullofinspiration.github.leetcode;

public class _0415_AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            if (num1 == null || num1.length() == 0) {
                return num2;
            }
            if (num2 == null || num2.length() == 0) {
                return num1;
            }
            int maxLength = Math.max(num1.length(), num2.length()) + 1;
            char[] res = new char[maxLength];
            int added = 0;
            for (int i = 0; i < maxLength; i++) {
                int curIndex = res.length - i - 1;
                int sum = 0;
                int firstIndex = num1.length() - i - 1;
                int secondIndex = num2.length() - i - 1;
                if (firstIndex >= 0) {
                    sum += (num1.charAt(firstIndex) - '0');
                }
                if (secondIndex >= 0) {
                    sum += (num2.charAt(secondIndex) - '0');
                }
                sum += added;
                if (sum >= 10) {
                    added = 1;
                    sum -= 10;
                } else {
                    added = 0;
                }
                if (curIndex != 0 || sum != 0) {
                    res[curIndex] = (char) (sum + '0');
                }
            }
            return new String(res).trim();
        }
    }
}
