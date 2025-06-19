package com.fullofinspiration.github.leetcode;


import org.junit.Assert;
import org.junit.Test;

public class _0207_CourseTest {
    @Test
    public void test00() {
        _0207_Course.Solution solution = new _0207_Course().new Solution();
        int[][] inputs = {{1, 0}};
        boolean ret = solution.canFinish(2, inputs);
        Assert.assertTrue(ret);
    }

    @Test
    public void test01() {
        _0207_Course.Solution solution = new _0207_Course().new Solution();
        int[][] inputs = {{1, 0}, {0, 1}};
        boolean ret = solution.canFinish(2, inputs);
        Assert.assertFalse(ret);
    }

}