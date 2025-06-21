package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0240_BinarySearchMatrixTest extends TestCase {
    @Test
    public void test00() {
        _0240_BinarySearchMatrix.Solution solution = new _0240_BinarySearchMatrix().new Solution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean ret = solution.searchMatrix(matrix, 5);
        Assert.assertTrue(ret);
    }

    @Test
    public void test01() {
        _0240_BinarySearchMatrix.Solution solution = new _0240_BinarySearchMatrix().new Solution();
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean ret = solution.searchMatrix(matrix, 20);
        Assert.assertFalse(ret);
    }

}