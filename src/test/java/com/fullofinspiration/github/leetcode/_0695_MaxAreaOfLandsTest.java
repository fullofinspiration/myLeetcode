package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0695_MaxAreaOfLandsTest {

    @Test
    public void test00() {
        _0695_MaxAreaOfLands.Solution solution = new _0695_MaxAreaOfLands().new Solution();
        int[][] ints = {
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};


        int i = solution.maxAreaOfIsland(ints);
        Assert.assertEquals(6, i);
    }

    @Test
    public void test01() {
        _0695_MaxAreaOfLands.Solution solution = new _0695_MaxAreaOfLands().new Solution();
        int[][] ints = {
                new int[]{0, 0, 0, 0, 0, 0, 0, 0}
        };
        int i = solution.maxAreaOfIsland(ints);
        Assert.assertEquals(0, i);
    }

}