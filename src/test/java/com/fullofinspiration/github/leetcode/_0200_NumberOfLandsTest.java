package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0200_NumberOfLandsTest {

    @Test
    public void test00() {
        _0200_NumberOfLands.Solution solution = new _0200_NumberOfLands().new Solution();

        char[][] chars = {
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        int i = solution.numIslands(chars);
        Assert.assertEquals(1, i);
    }

    @Test
    public void test01() {
        _0200_NumberOfLands.Solution solution = new _0200_NumberOfLands().new Solution();
        char[][] chars = {
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        };
        int i = solution.numIslands(chars);
        Assert.assertEquals(3, i);
    }

    @Test
    public void test02() {
        _0200_NumberOfLands.Solution solution = new _0200_NumberOfLands().new Solution();
        char[][] chars = {
                new char[]{'1', '1', '1'},
                new char[]{'0', '1', '0'},
                new char[]{'1', '1', '1'},
        };
        int i = solution.numIslands(chars);
        Assert.assertEquals(1, i);
    }

}