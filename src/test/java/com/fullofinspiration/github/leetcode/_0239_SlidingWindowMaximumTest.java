package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ArrayUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0239_SlidingWindowMaximumTest extends TestCase {
    @Test
    public void test00() {
        _0239_SlidingWindowMaximum.Solution solution = new _0239_SlidingWindowMaximum().new Solution();
        int[] rst = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] expect = new int[]{3, 3, 5, 5, 6, 7};
        boolean equal = ArrayUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0239_SlidingWindowMaximum.Solution solution = new _0239_SlidingWindowMaximum().new Solution();
        int[] rst = solution.maxSlidingWindow(new int[]{1}, 1);
        int[] expect = new int[]{1};
        boolean equal = ArrayUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0239_SlidingWindowMaximum.Solution solution = new _0239_SlidingWindowMaximum().new Solution();
        int[] rst = solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        int[] expect = new int[]{3, 3, 2, 5};
        boolean equal = ArrayUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

}