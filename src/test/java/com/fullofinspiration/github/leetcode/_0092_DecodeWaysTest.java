package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0092_DecodeWaysTest {
    private static final _0092_DecodeWays.Solution solution = new _0092_DecodeWays().new Solution();

    @Test
    public void test00() {
        int num = solution.numDecodings("12");
        Assert.assertEquals(2, num);
    }

    @Test
    public void test01() {
        int num = solution.numDecodings("226");
        Assert.assertEquals(3, num);
    }

    @Test
    public void test02() {
        int num = solution.numDecodings("0");
        Assert.assertEquals(0, num);
    }

    @Test
    public void test03() {
        int num = solution.numDecodings("06");
        Assert.assertEquals(0, num);
    }

    @Test
    public void test04() {
        int num = solution.numDecodings("230");
        Assert.assertEquals(0, num);
    }
}
