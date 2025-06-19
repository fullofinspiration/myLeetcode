package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _0046_PermutationTest {

    @Test
    public void test00() {
        _0046_Permutation.Solution solution = new _0046_Permutation().new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
        List<List<Integer>> all = Stream.of(
                Stream.of(1, 2, 3).collect(Collectors.toList()),
                Stream.of(1, 3, 2).collect(Collectors.toList()),
                Stream.of(2, 1, 3).collect(Collectors.toList()),
                Stream.of(2, 3, 1).collect(Collectors.toList()),
                Stream.of(3, 1, 2).collect(Collectors.toList()),
                Stream.of(3, 2, 1).collect(Collectors.toList()))
                .collect(Collectors.toList());
        Assert.assertEquals(all, permute);
    }

    @Test
    public void test01() {
        _0046_Permutation.Solution solution = new _0046_Permutation().new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{0, 1});
        List<List<Integer>> all = Stream.of(
                Stream.of(0, 1).collect(Collectors.toList()),
                Stream.of(1, 0).collect(Collectors.toList()))
                .collect(Collectors.toList());
        Assert.assertEquals(all, permute);
    }

    @Test
    public void test2() {
        _0046_Permutation.Solution solution = new _0046_Permutation().new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1});
        List<List<Integer>> all = Stream.of(
                Stream.of(1).collect(Collectors.toList()))
                .collect(Collectors.toList());
        Assert.assertEquals(all, permute);
    }

}