package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class _0131_PalindromePartitioningTest extends TestCase {
    @Test
    public void test00() {
        _0131_PalindromePartitioning.Solution solution = new _0131_PalindromePartitioning().new Solution();
        List<List<String>> rst = solution.partition("aab");
        List<String> expect1 = ImmutableList.of("a", "a", "b");
        List<String> expect2 = ImmutableList.of("aa", "b");
        List<List<String>> expect = ImmutableList.of(expect1, expect2);
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

}