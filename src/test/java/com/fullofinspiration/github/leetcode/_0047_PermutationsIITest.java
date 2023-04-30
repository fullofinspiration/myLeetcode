package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _0047_PermutationsIITest extends TestCase {
    @Test
    public void test00() {
        _0047_PermutationsII.Solution SOLUTION = new _0047_PermutationsII().new Solution();
        List<List<Integer>> permute = SOLUTION.permuteUnique(new int[]{1, 1, 2});
        List<List<Integer>> all = Stream.of(
                        Stream.of(1, 1, 2).collect(Collectors.toList()),
                        Stream.of(1, 2, 1).collect(Collectors.toList()),
                        Stream.of(2, 1, 1).collect(Collectors.toList()))
                .collect(Collectors.toList());
        Assert.assertEquals(all, permute);
    }

    @Test
    public void test01() {
        _0047_PermutationsII.Solution SOLUTION = new _0047_PermutationsII().new Solution();
        List<List<Integer>> permute = SOLUTION.permuteUnique(new int[]{1, 2, 3});
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

}