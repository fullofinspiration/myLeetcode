package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0088_MergeSortedArrayTest {
    private static final _0088_MergeSortedArray.Solution SOLUTION = new _0088_MergeSortedArray().new Solution();

    @Test
    public void test00() {
        int[] ints = new int[6];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        SOLUTION.merge(ints, 3, new int[]{2, 5, 6}, 3);
        Assert.assertEquals(Arrays.toString(new int[]{1, 2, 2, 3, 5, 6}), Arrays.toString(ints));
    }

    @Test
    public void test01() {
        int[] ints = new int[1];
        ints[0] = 1;
        SOLUTION.merge(ints, 1, new int[]{}, 0);
        Assert.assertEquals(Arrays.toString(new int[]{1}), Arrays.toString(ints));
    }

    @Test
    public void test02() {
        int[] ints = new int[1];
        SOLUTION.merge(ints, 0, new int[]{1}, 1);
        Assert.assertEquals(Arrays.toString(new int[]{1}), Arrays.toString(ints));
    }

    @Test
    public void test03() {
        int[] ints = new int[2];
        ints[0] = 2;
        SOLUTION.merge(ints, 1, new int[]{1}, 1);
        Assert.assertEquals(Arrays.toString(new int[]{1,2}), Arrays.toString(ints));
    }
}