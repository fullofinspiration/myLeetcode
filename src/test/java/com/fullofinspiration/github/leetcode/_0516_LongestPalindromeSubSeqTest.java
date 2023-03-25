package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0516_LongestPalindromeSubSeqTest extends TestCase {

    @Test
    public void test00() {
        _0516_LongestPalindromeSubSeq.Solution solution = new _0516_LongestPalindromeSubSeq().new Solution();
        int seq = solution.longestPalindromeSubseq("bbbab");
        Assert.assertEquals(4, seq);
    }

    @Test
    public void test01() {
        _0516_LongestPalindromeSubSeq.Solution solution = new _0516_LongestPalindromeSubSeq().new Solution();
        int seq = solution.longestPalindromeSubseq("cbbd");
        Assert.assertEquals(2, seq);
    }
}