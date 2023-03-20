package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class _0118_PascalIsTriangleTest extends TestCase {
    @Test
    public void test00() {
        _0118_PascalIsTriangle.Solution solution = new _0118_PascalIsTriangle().new Solution();
        List<List<Integer>> rst = solution.generate(5);
        List<List<Integer>> expect = ImmutableList.of(ImmutableList.of(1),
                ImmutableList.of(1, 1),
                ImmutableList.of(1, 2, 1),
                ImmutableList.of(1, 3, 3, 1),
                ImmutableList.of(1, 4, 6, 4, 1));
        boolean b = ListUtil.equalV2(expect, rst);
        Assert.assertTrue(b);
    }

    @Test
    public void test01() {
        _0118_PascalIsTriangle.Solution solution = new _0118_PascalIsTriangle().new Solution();
        List<List<Integer>> rst = solution.generate(1);
        List<List<Integer>> expect = ImmutableList.of(ImmutableList.of(1));
        boolean b = ListUtil.equalV2(expect, rst);
        Assert.assertTrue(b);
    }

}