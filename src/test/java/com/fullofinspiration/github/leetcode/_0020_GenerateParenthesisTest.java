package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _0020_GenerateParenthesisTest extends TestCase {
    private static final   _0020_GenerateParenthesis.Solution SOLUTION = new _0020_GenerateParenthesis().new Solution();

    @Test
    public void test00() {
        _0020_GenerateParenthesis.Solution solution = new _0020_GenerateParenthesis().new Solution();
        boolean valid = solution.isValid("()");
        Assert.assertTrue(valid);
    }

    @Test
    public void test01() {
        _0020_GenerateParenthesis.Solution solution = new _0020_GenerateParenthesis().new Solution();
        boolean valid = solution.isValid("()[]{}");
        Assert.assertTrue(valid);
    }

    @Test
    public void test02() {
        _0020_GenerateParenthesis.Solution solution = new _0020_GenerateParenthesis().new Solution();
        boolean valid = solution.isValid("(]");
        Assert.assertFalse(valid);
    }


    @Test
    public void test03() {
        assertTrue(SOLUTION.isValid("()"));
    }

    @Test
    public void test04() {
        assertTrue(SOLUTION.isValid("()[]{}"));
    }

    @Test
    public void test05() {
        assertFalse(SOLUTION.isValid("(]"));
    }

    @Test
    public void test06() {
        assertFalse(SOLUTION.isValid("([)]"));
    }


    @Test
    public void test07() {
        assertTrue(SOLUTION.isValid("{[]}"));
    }


}