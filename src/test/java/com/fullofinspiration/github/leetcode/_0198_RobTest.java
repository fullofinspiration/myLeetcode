package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0198_RobTest extends TestCase {
    @Test
    public void test00() {
        _0198_Rob.Solution solution = new _0198_Rob().new Solution();
        int rob = solution.rob(new int[]{1, 2, 3, 1});
        Assert.assertEquals(4, rob);
    }

    @Test
    public void test01() {
        _0198_Rob.Solution solution = new _0198_Rob().new Solution();
        int rob = solution.rob(new int[]{2, 7, 9, 3, 1});
        Assert.assertEquals(12, rob);
    }

    @Test
    public void test02() {
        _0198_Rob.Solution solution = new _0198_Rob().new Solution();
        int rob = solution.rob(new int[]{2, 1});
        Assert.assertEquals(2, rob);
    }


}