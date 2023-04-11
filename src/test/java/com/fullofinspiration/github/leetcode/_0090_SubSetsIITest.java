package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class _0090_SubSetsIITest extends TestCase {
    @Test
    public void test00() {
        _0090_SubSetsII.Solution SOLUTION = new _0090_SubSetsII().new Solution();
        int[] ints = {1, 2, 2};
        List<List<Integer>> rst = SOLUTION.subsetsWithDup(ints);
        List<List<Integer>> expect = ImmutableList.of(
                Collections.emptyList(),
                ImmutableList.of(1),
                ImmutableList.of(1, 2),
                ImmutableList.of(1, 2, 2),
                ImmutableList.of(2),
                ImmutableList.of(2, 2));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0090_SubSetsII.Solution SOLUTION = new _0090_SubSetsII().new Solution();
        int[] ints = {0};
        List<List<Integer>> rst = SOLUTION.subsetsWithDup(ints);
        List<List<Integer>> expect = ImmutableList.of(Collections.emptyList(),
                ImmutableList.of(0));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0090_SubSetsII.Solution SOLUTION = new _0090_SubSetsII().new Solution();
        int[] ints = {2, 2};
        List<List<Integer>> rst = SOLUTION.subsetsWithDup(ints);
        List<List<Integer>> expect = ImmutableList.of(
                Collections.emptyList(),
                ImmutableList.of(2),
                ImmutableList.of(2, 2));
        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

}