package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0279_NumsSquaresTest extends TestCase {
    @Test
    public void test00(){
        _0279_NumsSquares.Solution s = new _0279_NumsSquares().new Solution();
        int i = s.numSquares(12);
        Assert.assertEquals(3, i);
    }

    @Test
    public void test01(){
        _0279_NumsSquares.Solution s = new _0279_NumsSquares().new Solution();
        int i = s.numSquares(13);
        Assert.assertEquals(2, i);
    }
}