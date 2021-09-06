package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0136_SingleNumberTest {
    private static final _0136_SingleNumber.Solution SOLUTION = new _0136_SingleNumber().new Solution();

    @Test
    public void test00() {
        int[] input = {2, 2, 1};
        int singleNumber = SOLUTION.singleNumber(input);
        Assert.assertEquals(1, singleNumber);
    }

    @Test
    public void test01() {
        int[] input = {4,1,2,1,2};
        int singleNumber = SOLUTION.singleNumber(input);
        Assert.assertEquals(4, singleNumber);
    }

    @Test
    public void test02() {
        int[] input = {1};
        int singleNumber = SOLUTION.singleNumber(input);
        Assert.assertEquals(1, singleNumber);
    }
}