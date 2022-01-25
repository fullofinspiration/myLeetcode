package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0033_SearchRotatedSortedArrayTest {
    private static final _0033_SearchRotatedSortedArray.Solution SOLUTION = new _0033_SearchRotatedSortedArray().new Solution();

    @Test
    public void test00() {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        int search = SOLUTION.search(ints, 0);
        Assert.assertEquals(4, search);
    }

    @Test
    public void test01() {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        int search = SOLUTION.search(ints, 3);
        Assert.assertEquals(-1, search);
    }

    @Test
    public void test02() {
        int[] ints = {1};
        int search = SOLUTION.search(ints, 0);
        Assert.assertEquals(-1, search);
    }

    @Test
    public void test03() {
        int[] ints = {3, 1};
        int search = SOLUTION.search(ints, 1);
        Assert.assertEquals(1, search);
    }

    @Test
    public void test04() {
        int[] ints = {5, 1, 3};
        int search = SOLUTION.search(ints, 5);
        Assert.assertEquals(0, search);
    }

    @Test
    public void test05() {
        int[] ints = {5, 1, 3};
        int search = SOLUTION.search(ints, 3);
        Assert.assertEquals(2, search);
    }
}