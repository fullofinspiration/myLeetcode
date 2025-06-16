package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0152_MaxMultiplierSubArrayTest {
    private static final _0152_MaxMultiplierSubArray.Solution SOLUTION =
            new _0152_MaxMultiplierSubArray().new Solution();

    @Test
    public void test00() {
        int[] inputs = {2, 3, -2, 4};
        int actual = SOLUTION.maxProduct(inputs);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void test01() {
        int[] inputs = {-2, 0, -1};
        int actual = SOLUTION.maxProduct(inputs);
        Assert.assertEquals(0, actual);
    }


}