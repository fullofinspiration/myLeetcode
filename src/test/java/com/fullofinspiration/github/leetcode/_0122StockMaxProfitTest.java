package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0122StockMaxProfitTest extends TestCase {
    @Test
    public void test00() {
        _0122StockMaxProfit.Solution solution = new _0122StockMaxProfit().new Solution();
        int maxProfit = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.assertEquals(7, maxProfit);
    }

    @Test
    public void test01() {
        _0122StockMaxProfit.Solution solution = new _0122StockMaxProfit().new Solution();
        int maxProfit = solution.maxProfit(new int[]{1,2,3,4,5});
        Assert.assertEquals(4, maxProfit);
    }

    @Test
    public void test02() {
        _0122StockMaxProfit.Solution solution = new _0122StockMaxProfit().new Solution();
        int maxProfit = solution.maxProfit(new int[]{7,6,4,3,1});
        Assert.assertEquals(0, maxProfit);
    }

}