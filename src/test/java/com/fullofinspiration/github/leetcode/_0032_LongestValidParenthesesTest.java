package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0032_LongestValidParenthesesTest extends TestCase {
    @Test
    public void test00() {
        _0032_LongestValidParentheses.Solution solution = new _0032_LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses("(()");
        Assert.assertEquals(2, i);
    }

    @Test
    public void test01() {
        _0032_LongestValidParentheses.Solution solution = new _0032_LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses(")()())");
        Assert.assertEquals(4, i);
    }

    @Test
    public void test02() {
        _0032_LongestValidParentheses.Solution solution = new _0032_LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses("");
        Assert.assertEquals(0, i);
    }

    @Test
    public void test03() {
        _0032_LongestValidParentheses.Solution solution = new _0032_LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses("))))((()((");
        Assert.assertEquals(2, i);
    }

    @Test
    public void test04() {
        _0032_LongestValidParentheses.Solution solution = new _0032_LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses(")((()))(())(((");
        Assert.assertEquals(10, i);
    }

    @Test
    public void test05() {
        _0032_LongestValidParentheses.Solution solution = new _0032_LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses("())");
        Assert.assertEquals(2, i);
    }

    @Test
    public void test06() {
        _0032_LongestValidParentheses.Solution solution = new _0032_LongestValidParentheses().new Solution();
        int i = solution.longestValidParentheses("(()())");
        Assert.assertEquals(6, i);
    }

}