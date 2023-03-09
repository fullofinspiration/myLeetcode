package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0454_4SumIITest extends TestCase {
    @Test
    public void test00() {
        _0454_4SumII.Solution solution = new _0454_4SumII().new Solution();
        int rst = solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        Assert.assertEquals(2, rst);
    }

    @Test
    public void test01() {
        _0454_4SumII.Solution solution = new _0454_4SumII().new Solution();
        int rst = solution.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
        Assert.assertEquals(1, rst);
    }

}