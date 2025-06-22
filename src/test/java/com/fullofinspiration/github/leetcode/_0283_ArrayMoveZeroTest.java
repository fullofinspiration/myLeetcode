package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0283_ArrayMoveZeroTest extends TestCase {
    @Test
    public void test00() {
        _0283_ArrayMoveZero.Solution solution = new _0283_ArrayMoveZero().new Solution();
        int[] inputs = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(inputs);
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, inputs);
    }

    @Test
    public void test01() {
        _0283_ArrayMoveZero.Solution solution = new _0283_ArrayMoveZero().new Solution();
        int[] inputs = new int[]{0};
        solution.moveZeroes(inputs);
        Assert.assertArrayEquals(new int[]{0}, inputs);
    }

}