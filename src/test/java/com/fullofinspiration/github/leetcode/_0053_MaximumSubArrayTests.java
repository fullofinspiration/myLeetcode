package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0053_MaximumSubArrayTests {
    private static final _0053_MaximumSubArray.Solution SOLUTION = new _0053_MaximumSubArray().new Solution();

    @Test
    public void test00() {
        int maxSum = SOLUTION.maxSubArray(new int[]{1});
        assertEquals(1, maxSum);
    }

    @Test
    public void test01() {
        int maxSum = SOLUTION.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, maxSum);
    }

    @Test
    public void test02() {
        int maxSum = SOLUTION.maxSubArray(new int[]{1});
        assertEquals(1, maxSum);
    }

    @Test
    public void test03() {
        int maxSum = SOLUTION.maxSubArray(new int[]{0});
        assertEquals(0, maxSum);
    }

    @Test
    public void test04() {
        int maxSum = SOLUTION.maxSubArray(new int[]{-1});
        assertEquals(-1, maxSum);
    }


    @Test
    public void test05() {
        int maxSum = SOLUTION.maxSubArray(new int[]{-100000});
        assertEquals(-100000, maxSum);
    }

    @Test
    public void test06() {
        int maxSum = SOLUTION.maxSubArray(new int[]{1, 2});
        assertEquals(3, maxSum);
    }

}