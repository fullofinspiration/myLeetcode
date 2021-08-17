package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0912_SortAnArrayTests {

    private static final _0912_SortAnArray.Solution SOLUTION = new _0912_SortAnArray().new Solution();

    @Test
    public void test00() {
        int[] ints = SOLUTION.sortArray(new int[]{5, 2, 3, 1});
        Assert.assertEquals(Arrays.toString(new int[]{1, 2, 3, 5}), Arrays.toString(ints));
    }

    @Test
    public void test01() {
        int[] ints = SOLUTION.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        Assert.assertEquals(Arrays.toString(new int[]{0, 0, 1, 1, 2, 5}), Arrays.toString(ints));
    }

}