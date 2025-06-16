package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0084_LargestRectangleInHistogramTest {
    private static final _0084_LargestRectangleInHistogram.Solution SOLUTION = new _0084_LargestRectangleInHistogram().new Solution();

    @Test
    public void test00() {
        int[] inputs = new int[]{2, 1, 5, 6, 2, 3};
        int ret = SOLUTION.largestRectangleArea(inputs);
        Assert.assertEquals(10, ret);
    }

    @Test
    public void test01() {
        int[] inputs = new int[]{2, 4};
        int ret = SOLUTION.largestRectangleArea(inputs);
        Assert.assertEquals(4, ret);
    }

}