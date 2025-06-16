package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0045_JumpGame2Test extends TestCase {
    @Test
    public void test00() {
        _0045_JumpGame2.Solution solution = new _0045_JumpGame2().new Solution();
        int rst = solution.jump(new int[]{2, 3, 1, 1, 4});
        Assert.assertEquals(2, rst);
    }

    @Test
    public void test01() {
        _0045_JumpGame2.Solution solution = new _0045_JumpGame2().new Solution();
        int rst = solution.jump(new int[]{2, 3, 0, 1, 4});
        Assert.assertEquals(2, rst);
    }
    @Test
    public void test02() {
        _0045_JumpGame2.Solution solution = new _0045_JumpGame2().new Solution();
        int rst = solution.jump(new int[]{15, 10, 0, 1, 4});
        Assert.assertEquals(1, rst);
    }

}