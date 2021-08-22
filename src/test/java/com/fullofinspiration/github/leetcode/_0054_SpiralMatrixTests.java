package com.fullofinspiration.github.leetcode;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class _0054_SpiralMatrixTests {
    private static final _0054_SpiralMatrix.Solution SOLUTION = new _0054_SpiralMatrix().new Solution();

    @Test
    public void test00() {
        int[][] ints = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        List<Integer> integers = SOLUTION.spiralOrder(ints);
        List<Integer> expect = ImmutableList.of(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertEquals(expect, integers);
    }

    @Test
    public void test01() {
        int[][] ints = {
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        };
        List<Integer> integers = SOLUTION.spiralOrder(ints);
        List<Integer> expect = ImmutableList.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        assertEquals(expect, integers);
    }

    @Test
    public void test02() {
        int[][] ints = {
                new int[]{6, 9, 7}
        };
        List<Integer> integers = SOLUTION.spiralOrder(ints);
        List<Integer> expect = ImmutableList.of(6, 9, 7);
        assertEquals(expect, integers);
    }

    @Test
    public void test03() {
        int[][] ints = {
                new int[]{7},
                new int[]{9},
                new int[]{6}
        };
        List<Integer> integers = SOLUTION.spiralOrder(ints);
        List<Integer> expect = ImmutableList.of(7, 9, 6);
        assertEquals(expect, integers);
    }
}