package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0055_JumpGameTest extends TestCase {
    @Test
    public void test00() {
        _0055_JumpGame.Solution solution = new _0055_JumpGame().new Solution();
        boolean jump = solution.canJump(new int[]{2, 3, 1, 1, 4});
        Assert.assertTrue(jump);
    }

    @Test
    public void test01() {
        _0055_JumpGame.Solution solution = new _0055_JumpGame().new Solution();
        boolean jump = solution.canJump(new int[]{3, 2, 1, 0, 4});
        Assert.assertFalse(jump);
    }

}