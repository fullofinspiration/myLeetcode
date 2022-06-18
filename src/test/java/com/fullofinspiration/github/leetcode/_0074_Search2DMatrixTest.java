package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _0074_Search2DMatrixTest {
    private static final _0074_Search2DMatrix.Solution SOLUTION = new _0074_Search2DMatrix().new Solution();

    @Test
    public void test00() {
        int[][] matrices = {
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        boolean exist = SOLUTION.searchMatrix(matrices, 3);
        Assert.assertTrue(exist);
    }

    @Test
    public void test01() {
        int[][] matrices = {
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        boolean exist = SOLUTION.searchMatrix(matrices, 13);
        assertFalse(exist);
    }
    @Test
    public void test02() {
        int[][] matrices = {
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}
        };
        boolean exist = SOLUTION.searchMatrix(matrices, 23);
        assertTrue(exist);
    }
}