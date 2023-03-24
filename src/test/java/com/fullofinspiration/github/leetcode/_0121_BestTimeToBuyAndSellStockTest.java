package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0121_BestTimeToBuyAndSellStockTest extends TestCase {
    @Test
    public void test00() {
        _0121_BestTimeToBuyAndSellStock.Solution solution = new _0121_BestTimeToBuyAndSellStock().new Solution();
        int i = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(5, i);
    }

    @Test
    public void test01() {
        _0121_BestTimeToBuyAndSellStock.Solution solution = new _0121_BestTimeToBuyAndSellStock().new Solution();
        int i = solution.maxProfit(new int[]{7, 6, 4, 3, 1});
        Assert.assertEquals(0, i);
    }
}