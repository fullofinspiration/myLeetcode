package com.fullofinspiration.github.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * generateParenthesis0后面有空再看
 */
public class _0020_GenerateParenthesis {
    /**
     * https://leetcode.com/problems/valid-parentheses/solutions/9178/short-java-solution/?orderBy=most_votes
     * 更简洁点
     */
    class Solution {
        public boolean isValid(String s) {
            LinkedList<Character> all = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    all.push(')');
                } else if (c == '[') {
                    all.push(']');
                } else if (c == '{') {
                    all.push('}');
                } else if (all.isEmpty() || all.pop() != c) {
                    return false;
                }
            }
            return all.isEmpty();

        }
    }

    /**
     * 入栈，然后匹配
     * 错误1： 异常检测
     */
    class Solution01 {
        public boolean isValid(String s) {
            LinkedList<Character> all = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    all.push(c);
                } else {
                    if (all.isEmpty()) {
                        return false;
                    }
                    Character pop = all.pop();
                    if (pop == '(' && c != ')') {
                        return false;
                    }
                    if (pop == '[' && c != ']') {
                        return false;
                    }
                    if (pop == '{' && c != '}') {
                        return false;
                    }
                }
            }
            return all.isEmpty();
        }
    }

    class Solution00 {
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
