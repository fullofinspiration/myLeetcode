package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0189_MoveKInArrayTest extends TestCase {
    @Test
    public void test00() {
        _0189_MoveKInArray.Solution solution = new _0189_MoveKInArray().new Solution();
        int[] inputs = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(inputs, 3);
        int[] expect = {5, 6, 7, 1, 2, 3, 4};
        Assert.assertArrayEquals(expect, inputs);
    }

    @Test
    public void test01() {
        _0189_MoveKInArray.Solution solution = new _0189_MoveKInArray().new Solution();
        int[] inputs = new int[]{-1, -100, 3, 99};
        solution.rotate(inputs, 2);
        int[] expect = {3, 99, -1, -100};
        Assert.assertArrayEquals(expect, inputs);
    }

}