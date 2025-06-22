package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0560_SubSequenceSumTest extends TestCase {
    @Test
    public void test00() {
        _0560_SubSequenceSum.Solution solution = new _0560_SubSequenceSum().new Solution();
        int actual = solution.subarraySum(new int[]{1, 1, 2}, 2);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test01() {
        _0560_SubSequenceSum.Solution solution = new _0560_SubSequenceSum().new Solution();
        int actual = solution.subarraySum(new int[]{1, 2, 3}, 3);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void test02() {
        _0560_SubSequenceSum.Solution solution = new _0560_SubSequenceSum().new Solution();
        int actual = solution.subarraySum(new int[]{1, -1, 0}, 0);
        Assert.assertEquals(3, actual);
    }

}