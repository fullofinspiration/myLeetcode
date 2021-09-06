package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _0034_FirstAndLastPositionOfElementInSortedArrayTest {
    private static final _0034_FirstAndLastPositionOfElementInSortedArray.Solution SOLUTION =
            new _0034_FirstAndLastPositionOfElementInSortedArray().new Solution();

    @Test
    public void test00() {
        int[] rst = SOLUTION.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        int[] expect = {3, 4};
        assertEquals(Arrays.toString(expect), Arrays.toString(rst));
    }

    @Test
    public void test01() {
        int[] rst = SOLUTION.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        int[] expect = {-1, -1};
        assertEquals(Arrays.toString(expect), Arrays.toString(rst));
    }

    @Test
    public void test02() {
        int[] rst = SOLUTION.searchRange(new int[]{}, 6);
        int[] expect = {-1, -1};
        assertEquals(Arrays.toString(expect), Arrays.toString(rst));
    }
}