package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0169_MajorityElementTest {
    private static final _0169_MajorityElement.Solution SOLUTION = new _0169_MajorityElement().new Solution();

    @Test
    public void test00() {
        int[] ints = {3, 2, 3};
        int rst = SOLUTION.majorityElement(ints);
        Assert.assertEquals(3, rst);
    }

    @Test
    public void test01() {
        int[] ints = {2, 2, 1, 1, 1, 2, 2};
        int rst = SOLUTION.majorityElement(ints);
        Assert.assertEquals(2, rst);
    }

}