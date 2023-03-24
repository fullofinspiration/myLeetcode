package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0072_EditDistanceTest extends TestCase {
    @Test
    public void test00() {
        _0072_EditDistance.Solution solution = new _0072_EditDistance().new Solution();
        int i = solution.minDistance("horse", "ros");
        Assert.assertEquals(3, i);
    }
    @Test
    public void test01() {
        _0072_EditDistance.Solution solution = new _0072_EditDistance().new Solution();
        int i = solution.minDistance("intention", "execution");
        Assert.assertEquals(5, i);
    }

}