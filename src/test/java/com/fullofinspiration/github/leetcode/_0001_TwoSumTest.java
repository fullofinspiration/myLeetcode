package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0001_TwoSumTest {

    private static final _0001_TwoSum.Solution SOLUTION = new _0001_TwoSum().new Solution();

    @Test
    public void testTwoSum00() {
        int[] ints = SOLUTION.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertEquals(1, ints[0]);
        assertEquals(0,ints[1]);
    }

    @Test
    public void testTwoSum01() {
        int[] ints = SOLUTION.twoSum(new int[]{3,2,4}, 6);
        assertEquals(2, ints[0]);
        assertEquals(1,ints[1]);
    }

    @Test
    public void testTwoSum02() {
        int[] ints = SOLUTION.twoSum(new int[]{3,3}, 6);
        assertEquals(1, ints[0]);
        assertEquals(0,ints[1]);
    }

    @Test
    public void testTwoSum03() {
        int[] ints = SOLUTION.twoSum(new int[]{2222222,2222222}, 4444444);
        assertEquals(1, ints[0]);
        assertEquals(0,ints[1]);
    }
}