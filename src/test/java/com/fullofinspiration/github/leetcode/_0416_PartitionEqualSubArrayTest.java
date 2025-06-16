package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0416_PartitionEqualSubArrayTest {
    private static final _0416_PartitionEqualSubArray.Solution SOLUTION = new _0416_PartitionEqualSubArray().new Solution();

    @Test
    public void test00() {
        int[] input = new int[]{1, 5, 11, 5};
        Assert.assertTrue(SOLUTION.canPartition(input));
    }

    @Test
    public void test01() {
        int[] input = new int[]{1, 2, 3, 5};
        Assert.assertFalse(SOLUTION.canPartition(input));
    }

    @Test
    public void test02() {
        int[] input = new int[]{2, 2, 1, 1};
        Assert.assertTrue(SOLUTION.canPartition(input));
    }

    @Test
    public void test03() {
        int[] input = new int[]{2, 2, 3, 5};
        Assert.assertFalse(SOLUTION.canPartition(input));
    }


}