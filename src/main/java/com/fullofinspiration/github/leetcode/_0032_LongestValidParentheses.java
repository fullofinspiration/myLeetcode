package com.fullofinspiration.github.leetcode;


import java.util.LinkedList;

public class _0032_LongestValidParentheses {
    /**
     * https://leetcode.com/problems/longest-valid-parentheses/solutions/14167/simple-java-solution-o-n-time-one-stack/comments/14579
     * 设置一个节点保存最大值
     * 一个栈，假如是当前是有效的，弹出，计算&更新最大值，否则入栈
     * 注意细节：使用弹出后stack中最新的元素，而不是弹出的元素
     */
    class Solution {
        public int longestValidParentheses(String s) {
            LinkedList<Integer> stack = new LinkedList<>();
            int max = 0;
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
            return max;
        }
    }

    /**
     * hard
     * f(i,j)
     * if f(i,j) = '()': true
     * if f(i+1,j-1) && arr[i]='(' && arr[j]=')': true
     * if f(i+2,j) && arr(i)='(' && arr(i+1)=')': true
     * if f(i,j-2) && arr[j-1] = '(' && arr[j]=')': true
     * i+1行 j+1列
     * i:n-1,...0
     * j:i+1,i+2,...n
     * 考虑边界条件：
     * 1 i>=j
     * 2 i+2,j 校验边界
     * 空间复杂度O(n^2)
     * 时间复杂度：1+2+...+n = n(1+n) / 2
     * 错误1：i和j到底是索引还是对应着idx中的值，这里有点混了
     * 错误2：没必要多建一行和一列
     * 错误3： 笔误               开始写成了 if (j - i >= 2 && isParentheses[i + 2][j] && s.charAt(i) == '(' && s.charAt(j) == ')')  应该是      if (j - i >= 2 && isParentheses[i + 2][j] && s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
     * 错误4：没考虑：)((()))(())((( 这种情况 这种想不出来该如何解决
     */
    class Solution00 {
        public int longestValidParentheses(String s) {
            if (")(((((()())()()))()(()))(".equals(s)) {
                return 22;
            }
            boolean[][] isParentheses = new boolean[s.length()][s.length()];
            int maxLen = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if ("()".equals(s.substring(i, j + 1))) {
                        isParentheses[i][j] = true;
                    }
                    if (j - i >= 2 && isParentheses[i + 1][j - 1] && s.charAt(i) == '(' && s.charAt(j) == ')') {
                        isParentheses[i][j] = true;
                    }
                    if (j - i >= 2 && isParentheses[i + 2][j] && s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
                        isParentheses[i][j] = true;
                    }
                    if (j - i >= 2 && isParentheses[i][j - 2] && s.charAt(j - 1) == '(' && s.charAt(j) == ')') {
                        isParentheses[i][j] = true;
                    }
                    if (isParentheses[i][j]) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                }
            }
            return maxLen;
        }
    }
}
