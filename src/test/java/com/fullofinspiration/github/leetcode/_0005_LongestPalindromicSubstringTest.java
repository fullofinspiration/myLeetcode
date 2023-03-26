package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0005_LongestPalindromicSubstringTest {

    @Test
    public void test00() {
        _0005_LongestPalindromicSubstring.Solution solution = new _0005_LongestPalindromicSubstring().new Solution();
        String res = solution.longestPalindrome("babad");
        Assert.assertEquals("bab", res);
    }

    @Test
    public void test01() {
        _0005_LongestPalindromicSubstring.Solution solution = new _0005_LongestPalindromicSubstring().new Solution();
        String res = solution.longestPalindrome("cbbd");
        Assert.assertEquals("bb", res);
    }

    @Test
    public void test02() {
        _0005_LongestPalindromicSubstring.Solution solution = new _0005_LongestPalindromicSubstring().new Solution();
        String res = solution.longestPalindrome("a");
        Assert.assertEquals("a", res);
    }

    @Test
    public void test03() {
        _0005_LongestPalindromicSubstring.Solution solution = new _0005_LongestPalindromicSubstring().new Solution();
        String res = solution.longestPalindrome("ac");
        Assert.assertEquals("a", res);
    }

    @Test
    public void test04() {
        _0005_LongestPalindromicSubstring.Solution solution = new _0005_LongestPalindromicSubstring().new Solution();
        String res = solution.longestPalindrome("babaddtattarrattatddetartrateedredividerb");
        Assert.assertEquals("ddtattarrattatdd", res);
    }
}