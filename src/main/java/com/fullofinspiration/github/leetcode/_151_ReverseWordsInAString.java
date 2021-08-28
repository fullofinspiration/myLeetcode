package com.fullofinspiration.github.leetcode;

import java.util.LinkedList;

public class _151_ReverseWordsInAString {
    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return null;
            }
            LinkedList<String> all = new LinkedList<>();
            int index = 0;
            while (index < s.length()) {
                if (s.charAt(index) == ' ') {
                    index++;
                    continue;
                }
                int startIndex = index;
                while (index < s.length() && s.charAt(index) != ' ') {
                    index++;
                }
                String curString = s.substring(startIndex, index);
                all.push(curString);
                index++;
            }
            StringBuilder res = new StringBuilder();
            while (!all.isEmpty()) {
                res.append(" ");
                res.append(all.pop());
            }
            return res.toString().trim();
        }
    }
}
