package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _567_PermutationInStringTest extends TestCase {
    @Test
    public void test00() {
        _567_PermutationInString.Solution solution = new _567_PermutationInString().new Solution();
        boolean include = solution.checkInclusion("ab", "eidbaooo");
        Assert.assertTrue(include);
    }

    @Test
    public void test01() {
        _567_PermutationInString.Solution solution = new _567_PermutationInString().new Solution();
        boolean include = solution.checkInclusion("ab", "eidboaoo");
        Assert.assertFalse(include);
    }
    @Test
    public void test02() {
        _567_PermutationInString.Solution solution = new _567_PermutationInString().new Solution();
        boolean include = solution.checkInclusion("adc", "dcda");
        Assert.assertTrue(include);
    }

}