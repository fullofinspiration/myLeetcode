package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class _0438_AnagramFinderTest extends TestCase {
    @Test
    public void test00() {
        _0438_AnagramFinder.Solution solution = new _0438_AnagramFinder().new Solution();
        List<Integer> actual = solution.findAnagrams("cbaebabacd", "abc");
        List<Integer> expect = ImmutableList.of(0, 6);
        boolean equal = ListUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0438_AnagramFinder.Solution solution = new _0438_AnagramFinder().new Solution();
        List<Integer> actual = solution.findAnagrams("abab", "ab");
        List<Integer> expect = ImmutableList.of(0, 1, 2);
        boolean equal = ListUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

}