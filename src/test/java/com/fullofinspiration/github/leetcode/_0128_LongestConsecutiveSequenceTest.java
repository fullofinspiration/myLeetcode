package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0128_LongestConsecutiveSequenceTest extends TestCase {
    @Test
    public void test00() {
        _0128_LongestConsecutiveSequence.Solution solution = new _0128_LongestConsecutiveSequence().new Solution();
        int actual = solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        Assert.assertEquals(4, actual);
    }

    @Test
    public void test01() {
        _0128_LongestConsecutiveSequence.Solution solution = new _0128_LongestConsecutiveSequence().new Solution();
        int actual = solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        Assert.assertEquals(9, actual);
    }

    @Test
    public void test02() {
        _0128_LongestConsecutiveSequence.Solution solution = new _0128_LongestConsecutiveSequence().new Solution();
        int actual = solution.longestConsecutive(new int[]{1, 0, 1, 2});
        Assert.assertEquals(3, actual);
    }

}