package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import java.util.List;

public class _0078_SubSetsTest {
    private static final _0078_SubSets.Solution SOLUTION = new _0078_SubSets().new Solution();

    @Test
    public void test00() {
        int[] ints = {1, 2, 3};
        List<List<Integer>> subsets = SOLUTION.subsets(ints);
        System.out.println(subsets);
    }

}