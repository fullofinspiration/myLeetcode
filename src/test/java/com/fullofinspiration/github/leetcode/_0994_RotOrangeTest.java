package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0994_RotOrangeTest {
    @Test
    public void test00() {
        _0994_RotOrange.Solution solution = new _0994_RotOrange().new Solution();
        int[][] inputs = {
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };
        int i = solution.orangesRotting(inputs);
        Assert.assertEquals(4, i);
    }

    @Test
    public void test01() {
        _0994_RotOrange.Solution solution = new _0994_RotOrange().new Solution();
        int[][] inputs = {
                {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
        };
        int i = solution.orangesRotting(inputs);
        Assert.assertEquals(-1, i);
    }

    @Test
    public void test02() {
        _0994_RotOrange.Solution solution = new _0994_RotOrange().new Solution();
        int[][] inputs = {
                {0, 2}
        };
        int i = solution.orangesRotting(inputs);
        Assert.assertEquals(0, i);
    }
}