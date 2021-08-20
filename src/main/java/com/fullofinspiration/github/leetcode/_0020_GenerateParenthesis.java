package com.fullofinspiration.github.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * generateParenthesis0后面有空再看
 */
public class _0020_GenerateParenthesis {
    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            LinkedList<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (c.equals('(') || c.equals('[') || c.equals('{')) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character left = stack.pop();
                    if (!left.equals(getPair(c))) {
                        return false;
                    }
                }
            }
            if (stack.isEmpty()) {
                return true;
            }
            return false;
        }
        private Character getPair(Character c) {
            if (c.equals(')')) {
                return '(';
            }
            if (c.equals(']')) {
                return '[';
            }
            if (c.equals('}')) {
                return '{';
            }
            throw new IllegalArgumentException(String.format("Illegal argument: %s", c));
        }
    }

    public List<String> generateParenthesis0(int n) {
        List<String> lists = new LinkedList<>();
        backtrace(lists, "", 0, 0, 0, n);
        return lists;
    }

    public void backtrace(List<String> list, String string, int total, int left, int right, int max) {
        if (total == max * 2) {
            list.add(string);
            return;
        }
        if (left < max)
            backtrace(list, string + "(", total + 1, left + 1, right, max);
        if (right < left)
            backtrace(list, string + ")", total + 1, left, right + 1, max);
    }

    public static void main(String[] args) {
        _0020_GenerateParenthesis a = new _0020_GenerateParenthesis();
        List<String> lists = a.generateParenthesis0(3);
        for (String list : lists)
            System.out.println(list);
    }
}
