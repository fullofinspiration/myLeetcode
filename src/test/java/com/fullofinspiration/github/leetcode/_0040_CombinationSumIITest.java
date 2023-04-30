package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class _0040_CombinationSumIITest extends TestCase {

    @Test
    public void test00() {
        int[] ints = {10, 1, 2, 7, 6, 1, 5};
        _0040_CombinationSumII.Solution solution = new _0040_CombinationSumII().new Solution();
        List<List<Integer>> rst = solution.combinationSum2(ints, 8);
        List<List<Integer>> expect = ImmutableList.of(
                ImmutableList.of(1, 1, 6),
                ImmutableList.of(1, 2, 5),
                ImmutableList.of(1, 7),
                ImmutableList.of(2, 6));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        int[] ints = {2, 5, 2, 1, 2};
        _0040_CombinationSumII.Solution solution = new _0040_CombinationSumII().new Solution();
        List<List<Integer>> rst = solution.combinationSum2(ints, 5);
        List<List<Integer>> expect = ImmutableList.of(
                ImmutableList.of(1, 2, 2),
                ImmutableList.of(5));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        int[] ints = {10, 1, 2, 7, 6, 1, 5};
        _0040_CombinationSumII.Solution solution = new _0040_CombinationSumII().new Solution();
        List<List<Integer>> rst = solution.combinationSum2(ints, 8);
        List<List<Integer>> expect = ImmutableList.of(
                ImmutableList.of(1, 1, 6),
                ImmutableList.of(1, 2, 5),
                ImmutableList.of(1, 7),
                ImmutableList.of(2, 6));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }
}