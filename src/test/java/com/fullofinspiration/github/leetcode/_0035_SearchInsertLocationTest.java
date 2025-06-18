package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0035_SearchInsertLocationTest {
    private static final _0035_SearchInsertLocation.Solution SOLUTION = new _0035_SearchInsertLocation().new Solution();

    @Test
    public void test00() {
        int[] inputs = new int[]{1, 3, 5, 6};
        int actual = SOLUTION.searchInsert(inputs, 5);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test01() {
        int[] inputs = new int[]{1, 3, 5, 6};
        int actual = SOLUTION.searchInsert(inputs, 2);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void test02() {
        int[] inputs = new int[]{1, 3, 5, 6};
        int actual = SOLUTION.searchInsert(inputs, 7);
        Assert.assertEquals(4, actual);
    }
}