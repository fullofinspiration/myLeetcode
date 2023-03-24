package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0300_LongestIncreasingSubsequenceTest {
    private static final _0300_LongestIncreasingSubsequence.Solution SOLUTION = new _0300_LongestIncreasingSubsequence().new Solution();

    @Test
    public void test00() {
        int length = SOLUTION.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        Assert.assertEquals(4, length);
    }

    @Test
    public void test01() {
        int length = SOLUTION.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
        Assert.assertEquals(4, length);
    }


    @Test
    public void test02() {
        int length = SOLUTION.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7});
        Assert.assertEquals(1, length);
    }

}