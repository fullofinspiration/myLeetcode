package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class _0349_IntersectionOfTwoArraysTest extends TestCase {
    @Test
    public void test00() {
        _0349_IntersectionOfTwoArrays.Solution solution = new _0349_IntersectionOfTwoArrays().new Solution();
        int[] intersection = solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        int[] expect = new int[]{2};
        boolean equal = isEqual(expect, intersection);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0349_IntersectionOfTwoArrays.Solution solution = new _0349_IntersectionOfTwoArrays().new Solution();
        int[] intersection = solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        int[] expect = new int[]{9, 4};
        boolean equal = isEqual(expect, intersection);
        Assert.assertTrue(equal);
    }

    private boolean isEqual(int[] first, int[] second) {
        if (!isAllElementUnique(first) || !isAllElementUnique(second)) {
            return false;
        }
        Set<Integer> all = new HashSet<>();
        for (int i : first) {
            all.add(i);
        }
        for (int i : second) {
            if (!all.contains(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllElementUnique(int[] val) {
        Set<Integer> all = new HashSet<>();
        for (int i : val) {
            if (all.contains(i)) {
                return false;
            }
            all.add(i);
        }
        return true;
    }
}