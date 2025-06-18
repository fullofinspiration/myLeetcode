package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0153FindMinimumInRotatedSortedArrayTest {
    private static final _0153FindMinimumInRotatedSortedArray.Solution SOLUTION = new _0153FindMinimumInRotatedSortedArray().new Solution();

    @Test
    public void test00() {
        int[] ints = {3, 4, 5, 1, 2};
        int min = SOLUTION.findMin(ints);
        assertEquals(1, min);
    }

    @Test
    public void test01() {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        int min = SOLUTION.findMin(ints);
        assertEquals(0, min);
    }

    @Test
    public void test02() {
        int[] ints = {11, 13, 15, 17};
        int min = SOLUTION.findMin(ints);
        assertEquals(11, min);
    }

    @Test
    public void test03() {
        int[] ints = {3, 1, 2};
        int min = SOLUTION.findMin(ints);
        assertEquals(1, min);
    }

}