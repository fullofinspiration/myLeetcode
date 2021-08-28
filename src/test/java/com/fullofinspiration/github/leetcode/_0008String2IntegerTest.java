package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0008String2IntegerTest {
    private static final _0008String2Integer.Solution SOLUTION = new _0008String2Integer().new Solution();

    @Test
    public void test00() {
        int i = SOLUTION.myAtoi("42");
        Assert.assertEquals(42, i);
    }

    @Test
    public void test01() {
        int i = SOLUTION.myAtoi("-42");
        Assert.assertEquals(-42, i);
    }

    @Test
    public void test02() {
        int i = SOLUTION.myAtoi("4193");
        Assert.assertEquals(4193, i);
    }

    @Test
    public void test03() {
        int i = SOLUTION.myAtoi("words and 987");
        Assert.assertEquals(0, i);
    }

    @Test
    public void test04() {
        int i = SOLUTION.myAtoi("-91283472332");
        Assert.assertEquals(-2147483648, i);
    }
}