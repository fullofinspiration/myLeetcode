package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _1143_LongestCommonSubSequenceTest {
    private static final _1143_LongestCommonSubSequence.Solution SOLUTION = new _1143_LongestCommonSubSequence().new Solution();

    @Test
    public void test00() {
        int i = SOLUTION.longestCommonSubsequence("abcde", "ace");
        Assert.assertEquals(3, i);
    }

    @Test
    public void test01() {
        int i = SOLUTION.longestCommonSubsequence("abc", "abc");
        Assert.assertEquals(3, i);
    }

    @Test
    public void test02() {
        int i = SOLUTION.longestCommonSubsequence("abc", "def");
        Assert.assertEquals(0, i);
    }

}