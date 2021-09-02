package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0718_MaximumLengthOfRepeatedSubArrayTest {
    private static final _0718_MaximumLengthOfRepeatedSubArray.Solution SOLUTION =
            new _0718_MaximumLengthOfRepeatedSubArray().new Solution();

    @Test
    public void test00() {
        int[] first = {1, 2, 3, 2, 1};
        int[] second = {3, 2, 1, 4, 7};
        int length = SOLUTION.findLength(first, second);
        assertEquals(3, length);
    }

    @Test
    public void test01() {
        int[] first = {0, 0, 0, 0, 0};
        int[] second = {0, 0, 0, 0, 0};
        int length = SOLUTION.findLength(first, second);
        assertEquals(5, length);
    }

}