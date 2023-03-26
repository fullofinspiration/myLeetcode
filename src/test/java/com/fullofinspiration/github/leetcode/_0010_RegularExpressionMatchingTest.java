package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0010_RegularExpressionMatchingTest extends TestCase {
    @Test
    public void test00() {
        _0010_RegularExpressionMatching.Solution solution = new _0010_RegularExpressionMatching().new Solution();
        boolean match = solution.isMatch("aa", "a");
        Assert.assertFalse(match);
    }

    @Test
    public void test01() {
        _0010_RegularExpressionMatching.Solution solution = new _0010_RegularExpressionMatching().new Solution();
        boolean match = solution.isMatch("aa", "a*");
        Assert.assertTrue(match);
    }

    @Test
    public void test02() {
        _0010_RegularExpressionMatching.Solution solution = new _0010_RegularExpressionMatching().new Solution();
        boolean match = solution.isMatch("ab", ".*");
        Assert.assertTrue(match);
    }
    @Test
    public void test03() {
        _0010_RegularExpressionMatching.Solution solution = new _0010_RegularExpressionMatching().new Solution();
        boolean match = solution.isMatch("aab", "c*a*b");
        Assert.assertTrue(match);
    }
}