package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0056_MergeIntervalTest {
    private static final _0056_MergeInterval.Solution SOLUTION = new _0056_MergeInterval().new Solution();

    @Test
    public void test00() {
        int[][] res = SOLUTION.merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        });

        int[][] expect = {
                {1, 6},
                {8, 10},
                {15, 18}
        };

        assertEquals(expect, res);
    }

    @Test
    public void test01() {
        int[][] res = SOLUTION.merge(new int[][]{
                {1, 4},
                {4, 5}
        });

        int[][] expect = {
                {1, 5},
        };

        assertEquals(expect, res);
    }
    @Test
    public void test02() {
        int[][] res = SOLUTION.merge(new int[][]{
                {1, 4},
                {2, 3}
        });

        int[][] expect = {
                {1, 4},
        };

        assertEquals(expect, res);
    }

    private void assertEquals(int[][] expect, int[][] res) {
        for (int i = 0; i < res.length; i++) {
            Assert.assertEquals(Arrays.toString(res[i]), Arrays.toString(expect[i]));
        }
    }
}