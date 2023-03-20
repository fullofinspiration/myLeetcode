package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0062_UniquePathCountTest extends TestCase {
    @Test
    public void test00() {
        _0062_UniquePathCount.Solution solution = new _0062_UniquePathCount().new Solution();
        int i = solution.uniquePaths(3, 7);
        Assert.assertEquals(28, i);
    }

    @Test
    public void test01() {
        _0062_UniquePathCount.Solution solution = new _0062_UniquePathCount().new Solution();
        int i = solution.uniquePaths(3, 2);
        Assert.assertEquals(3, i);
    }

}