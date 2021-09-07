package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class _0039_CombinationSumTest {
    private static final _0039_CombinationSum.Solution SOLUTION = new _0039_CombinationSum().new Solution();

    @Test
    public void test00() {
        int[] ints = {2, 3, 6, 7};
        List<List<Integer>> rst = SOLUTION.combinationSum(ints, 7);
        List<List<Integer>> expect = ImmutableList.of(ImmutableList.of(7), ImmutableList.of(2, 2, 3));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        int[] ints = {2, 3, 5};
        List<List<Integer>> rst = SOLUTION.combinationSum(ints, 8);
        List<List<Integer>> expect = ImmutableList.of(ImmutableList.of(2, 2, 2, 2), ImmutableList.of(2, 3, 3), ImmutableList.of(3, 5));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        int[] ints = {2};
        List<List<Integer>> rst = SOLUTION.combinationSum(ints, 1);
        List<List<Integer>> expect = Collections.emptyList();
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test03() {
        int[] ints = {1};
        List<List<Integer>> rst = SOLUTION.combinationSum(ints, 1);
        List<List<Integer>> expect = ImmutableList.of(ImmutableList.of(1));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test04() {
        int[] ints = {1};
        List<List<Integer>> rst = SOLUTION.combinationSum(ints, 2);
        List<List<Integer>> expect = ImmutableList.of(ImmutableList.of(1, 1));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

}