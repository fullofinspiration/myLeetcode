package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0076_MinimumWindowSubStringTest extends TestCase {
    @Test
    public void test00() {
        _0076_MinimumWindowSubString.Solution solution = new _0076_MinimumWindowSubString().new Solution();
        String s = solution.minWindow("ADOBECODEBANC", "ABC");
        Assert.assertEquals("BANC", s);
    }

    @Test
    public void test01() {
        _0076_MinimumWindowSubString.Solution solution = new _0076_MinimumWindowSubString().new Solution();
        String s = solution.minWindow("a", "a");
        Assert.assertEquals("a", s);
    }
    @Test
    public void test02() {
        _0076_MinimumWindowSubString.Solution solution = new _0076_MinimumWindowSubString().new Solution();
        String s = solution.minWindow("a", "aa");
        Assert.assertEquals("", s);
    }

    @Test
    public void test03() {
        _0076_MinimumWindowSubString.Solution solution = new _0076_MinimumWindowSubString().new Solution();
        String s = solution.minWindow("aa", "aa");
        Assert.assertEquals("aa", s);
    }

}