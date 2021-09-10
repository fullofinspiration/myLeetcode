package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0042_TrappingRainWaterTest {
    private static final _0042_TrappingRainWater.Solution SOLUTION = new _0042_TrappingRainWater().new Solution();

    @Test
    public void test00() {
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = SOLUTION.trap(ints);
        assertEquals(6, trap);
    }

    @Test
    public void test01() {
        int[] ints = {4, 2, 0, 3, 2, 5};
        int trap = SOLUTION.trap(ints);
        assertEquals(9, trap);
    }

}