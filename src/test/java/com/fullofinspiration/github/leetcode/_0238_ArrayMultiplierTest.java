package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0238_ArrayMultiplierTest extends TestCase {
    @Test
    public void test00() {
        _0238_ArrayMultiplier.Solution solution = new _0238_ArrayMultiplier().new Solution();
        int[] ints = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        int[] expect = new int[]{24,12,8,6};
        Assert.assertArrayEquals(expect, ints);
    }

    @Test
    public void test01() {
        _0238_ArrayMultiplier.Solution solution = new _0238_ArrayMultiplier().new Solution();
        int[] ints = solution.productExceptSelf(new int[]{-1,1,0,-3,3});
        Assert.assertArrayEquals(new int[]{0,0,9,0,0}, ints);
    }
}