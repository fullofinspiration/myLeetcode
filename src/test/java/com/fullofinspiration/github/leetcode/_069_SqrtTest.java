package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _069_SqrtTest {
    private static final _069_Sqrt.Solution SOLUTION = new _069_Sqrt().new Solution();

    @Test
    public void test00() {
        int i = SOLUTION.mySqrt(4);
        Assert.assertEquals(2, i);
    }

    @Test
    public void test01() {
        int i = SOLUTION.mySqrt(8);
        Assert.assertEquals(2, i);
    }

    @Test
    public void test02() {
        int i = SOLUTION.mySqrt(1);
        Assert.assertEquals(1, i);
    }

}