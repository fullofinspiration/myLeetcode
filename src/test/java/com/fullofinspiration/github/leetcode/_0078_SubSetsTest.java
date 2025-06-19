package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0078_SubSetsTest {
    private static final _0078_SubSets.Solution SOLUTION = new _0078_SubSets().new Solution();

    @Test
    public void test00() {
        int[] ints = {1, 2, 3};
        List<List<Integer>> actual = SOLUTION.subsets(ints);
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(new ArrayList<>());
        expect.add(Arrays.asList(1));
        expect.add(Arrays.asList(2));
        expect.add(Arrays.asList(1, 2));
        expect.add(Arrays.asList(3));
        expect.add(Arrays.asList(1, 3));
        expect.add(Arrays.asList(2, 3));
        expect.add(Arrays.asList(1, 2, 3));
        boolean equal = ListUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    public void test01() {
        int[] ints = {0};
        List<List<Integer>> actual = SOLUTION.subsets(ints);
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(new ArrayList<>());
        expect.add(Arrays.asList(0));
        boolean equal = ListUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }
}