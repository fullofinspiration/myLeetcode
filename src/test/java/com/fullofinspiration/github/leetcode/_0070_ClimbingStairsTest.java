package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0070_ClimbingStairsTest {
    private static final _0070_ClimbingStairs.Solution SOLUTION = new _0070_ClimbingStairs().new Solution();

    @Test
    public void test00() {
        int i = SOLUTION.climbStairs(2);
        Assert.assertEquals(2, i);
    }

    @Test
    public void test01() {
        int i = SOLUTION.climbStairs(3);
        Assert.assertEquals(3, i);
    }
    @Test
    public void test02() {
        int i = SOLUTION.climbStairs(45);
        Assert.assertEquals(1836311903, i);
    }

}