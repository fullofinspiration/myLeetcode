package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0209_MinimumSizeSubArraySumTest extends TestCase {
    @Test
    public void test00() {
        _0209_MinimumSizeSubArraySum.Solution solution = new _0209_MinimumSizeSubArraySum().new Solution();
        int rst = solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        Assert.assertEquals(2, rst);
    }
    @Test
    public void test01() {
        _0209_MinimumSizeSubArraySum.Solution solution = new _0209_MinimumSizeSubArraySum().new Solution();
        int rst = solution.minSubArrayLen(4, new int[]{1,4,4});
        Assert.assertEquals(1, rst);
    }

    @Test
    public void test02() {
        _0209_MinimumSizeSubArraySum.Solution solution = new _0209_MinimumSizeSubArraySum().new Solution();
        int rst = solution.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        Assert.assertEquals(0, rst);
    }


}