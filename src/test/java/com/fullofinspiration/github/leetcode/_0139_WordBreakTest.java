package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0139_WordBreakTest extends TestCase {

    @Test
    public void test00() {
        _0139_WordBreak.Solution solution = new _0139_WordBreak().new Solution();
        boolean b = solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
        Assert.assertTrue(b);
    }

    @Test
    public void test01() {
        _0139_WordBreak.Solution solution = new _0139_WordBreak().new Solution();
        boolean b = solution.wordBreak("applepenapple", Arrays.asList("apple", "pen"));
        Assert.assertTrue(b);
    }

    @Test
    public void test02() {
        _0139_WordBreak.Solution solution = new _0139_WordBreak().new Solution();
        boolean b = solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        Assert.assertFalse(b);
    }
}