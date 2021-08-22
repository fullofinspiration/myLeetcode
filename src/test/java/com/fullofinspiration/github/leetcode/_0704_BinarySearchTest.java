package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0704_BinarySearchTest {
    private static final _0704_BinarySearch.Solution SOLUTION = new _0704_BinarySearch().new Solution();

    @Test
    public void test00() {
        int[] ints = {-1, 0, 3, 5, 9, 12};
        int search = SOLUTION.search(ints, 9);
        Assert.assertEquals(4, search);
    }

    @Test
    public void test01() {
        int[] ints = {-1, 0, 3, 5, 9, 12};
        int search = SOLUTION.search(ints, 2);
        Assert.assertEquals(-1, search);
    }
}