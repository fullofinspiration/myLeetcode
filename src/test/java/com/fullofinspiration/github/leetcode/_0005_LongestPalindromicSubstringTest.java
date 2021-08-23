package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0005_LongestPalindromicSubstringTest {
    private static final _0005_LongestPalindromicSubstring.Solution SOLUTION = new _0005_LongestPalindromicSubstring().new Solution();

    @Test
    public void test00() {
        String res = SOLUTION.longestPalindrome("babad");
        Assert.assertEquals("bab", res);
    }

    @Test
    public void test01() {
        String res = SOLUTION.longestPalindrome("cbbd");
        Assert.assertEquals("bb", res);
    }

    @Test
    public void test02() {
        String res = SOLUTION.longestPalindrome("a");
        Assert.assertEquals("a", res);
    }

    @Test
    public void test03() {
        String res = SOLUTION.longestPalindrome("ac");
        Assert.assertEquals("a", res);
    }

    @Test
    public void test04() {
        String res = SOLUTION.longestPalindrome("babaddtattarrattatddetartrateedredividerb");
        Assert.assertEquals("ddtattarrattatdd", res);
    }
}