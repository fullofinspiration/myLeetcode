package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0415_AddStringsTests {
    private static final _0415_AddStrings.Solution SOLUTION = new _0415_AddStrings().new Solution();

    @Test
    public void test00() {
        String s = SOLUTION.addStrings("111", "222");
        Assert.assertEquals("333", s);
    }
    @Test
    public void test01() {
        String s = SOLUTION.addStrings("119", "222");
        Assert.assertEquals("341", s);
    }

    @Test
    public void test02() {
        String s = SOLUTION.addStrings("11", "123");
        Assert.assertEquals("134", s);
    }
    @Test
    public void test03() {
        String s = SOLUTION.addStrings("1", "9");
        Assert.assertEquals("10", s);
    }


}