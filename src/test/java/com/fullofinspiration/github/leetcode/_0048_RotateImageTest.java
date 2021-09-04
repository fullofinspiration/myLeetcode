package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _0048_RotateImageTest {
    private static final _0048_RotateImage.Solution SOLUTION = new _0048_RotateImage().new Solution();

    @Test
    public void test00() {
        int[][] inputs = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        SOLUTION.rotate(inputs);
        int[][] expect = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        for (int i = 0; i < expect.length; i++) {
            assertEquals(Arrays.toString(expect[i]), Arrays.toString(inputs[i]));
        }
    }

    @Test
    public void test01() {
        int[][] inputs = {
                {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
        };
        SOLUTION.rotate(inputs);
        int[][] expect = {
                {15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}
        };
        for (int i = 0; i < expect.length; i++) {
            assertEquals(Arrays.toString(expect[i]), Arrays.toString(inputs[i]));
        }
    }
}