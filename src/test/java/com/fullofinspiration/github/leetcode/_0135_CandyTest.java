package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0135_CandyTest extends TestCase {
    @Test
    public void test00() {
        _0135_Candy.Solution solution = new _0135_Candy().new Solution();
        int actual = solution.candy(new int[]{1, 0, 2});
        Assert.assertEquals(5, actual);
    }
    @Test
    public void test01() {
        _0135_Candy.Solution solution = new _0135_Candy().new Solution();
        int actual = solution.candy(new int[]{1, 2, 2});
        Assert.assertEquals(4, actual);
    }

}