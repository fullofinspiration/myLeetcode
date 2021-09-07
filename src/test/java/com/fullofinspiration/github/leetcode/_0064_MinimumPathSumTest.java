package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0064_MinimumPathSumTest {
    private static final _0064_MinimumPathSum.Solution SOLUTION = new _0064_MinimumPathSum().new Solution();

    @Test
    public void test00() {
        int[][] ints = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int minPathSum = SOLUTION.minPathSum(ints);
        assertEquals(7, minPathSum);
    }

    @Test
    public void test01() {
        int[][] ints = {
                {1, 2, 3},
                {4, 5, 6},
        };
        int minPathSum = SOLUTION.minPathSum(ints);
        assertEquals(12, minPathSum);
    }
}