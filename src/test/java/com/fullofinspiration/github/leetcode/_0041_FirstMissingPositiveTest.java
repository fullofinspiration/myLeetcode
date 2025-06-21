package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0041_FirstMissingPositiveTest extends TestCase {
    @Test
    public void test00() {
        _0041_FirstMissingPositive.Solution solution = new _0041_FirstMissingPositive().new Solution();
        int[] input = new int[]{1, 2, 0};
        int i = solution.firstMissingPositive(input);
        Assert.assertEquals(3, i);
    }

    @Test
    public void test01() {
        _0041_FirstMissingPositive.Solution solution = new _0041_FirstMissingPositive().new Solution();
        int[] input = new int[]{3, 4, -1, 1};
        int i = solution.firstMissingPositive(input);
        Assert.assertEquals(2, i);
    }

    @Test
    public void test02() {
        _0041_FirstMissingPositive.Solution solution = new _0041_FirstMissingPositive().new Solution();
        int[] input = new int[]{7, 8, 9, 11, 12};
        int i = solution.firstMissingPositive(input);
        Assert.assertEquals(1, i);
    }

}