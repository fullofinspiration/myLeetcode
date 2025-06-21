package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0073_Matrix_MarkZeroTest extends TestCase {
    @Test
    public void test00() {
        _0073_Matrix_MarkZero.Solution solution = new _0073_Matrix_MarkZero().new Solution();
        int[][] inputs = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(inputs);
        int[][] expects = {{1,0,1},{0,0,0},{1,0,1}};
        Assert.assertEquals(inputs, expects);
    }
    @Test
    public void test01() {
        _0073_Matrix_MarkZero.Solution solution = new _0073_Matrix_MarkZero().new Solution();
        int[][] inputs = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(inputs);
        int[][] expects = {{0,0,0,0},{0,4,5,0},{0,3,1,0}};
        Assert.assertEquals(inputs, expects);
    }

}