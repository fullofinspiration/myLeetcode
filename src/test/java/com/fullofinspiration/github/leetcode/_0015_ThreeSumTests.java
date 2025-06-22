package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class _0015_ThreeSumTests {
    @Test
    public void test00() {
        _0015_ThreeSum.Solution solution = new _0015_ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, lists.size());
        List<Integer> integers = lists.get(0);
        assertEquals(Arrays.toString(new int[]{-1, -1, 2}), integers.toString());
        List<Integer> integers1 = lists.get(1);
        assertEquals(Arrays.toString(new int[]{-1, 0, 1}), integers1.toString());
    }

    @Test
    public void test01() {
        _0015_ThreeSum.Solution solution = new _0015_ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{});
        assertEquals(0, lists.size());
    }

    @Test
    public void test02() {
        _0015_ThreeSum.Solution solution = new _0015_ThreeSum().new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[]{0});
        assertEquals(0, lists.size());
    }

    @Test
    public void test03() {
        _0015_ThreeSum.Solution solution = new _0015_ThreeSum().new Solution();
        List<List<Integer>> actual = solution.threeSum(new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10});
        List<List<Integer>> expect = asList(
                asList(-10, 5, 5),
                asList(-5, 0, 5),
                asList(-4, 2, 2),
                asList(-3, -2, 5),
                asList(-3, 1, 2),
                asList(-2, 0, 2)
        );
        boolean equal = ListUtil.equalV2(expect, actual);
        Assert.assertTrue(equal);
    }
}