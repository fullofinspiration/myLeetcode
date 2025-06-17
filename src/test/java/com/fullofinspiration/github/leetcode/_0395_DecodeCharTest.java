package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0395_DecodeCharTest {
    private static final _0395_DecodeChar.Solution SOLUTION = new _0395_DecodeChar().new Solution();
    @Test
    public void test00() {
        String input = "3[a]2[bc]";
        String actual = SOLUTION.decodeString(input);
        String expect = "aaabcbc";
        Assert.assertEquals(expect, actual);
    }
    @Test
    public void test01() {
        String input = "3[a2[c]]";
        String actual = SOLUTION.decodeString(input);
        String expect = "accaccacc";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test02() {
        String input = "2[abc]3[cd]ef";
        String actual = SOLUTION.decodeString(input);
        String expect = "abcabccdcdcdef";
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void test03() {
        String input = "abc3[cd]xyz";
        String actual = SOLUTION.decodeString(input);
        String expect = "abccdcdcdxyz";
        Assert.assertEquals(expect, actual);
    }
}