package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ArrayUtil;
import com.fullofinspiration.github.util.ListUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _977_SquaresOfASortedArrayTest extends TestCase {
    @Test
    public void test00() {
        _977_SquaresOfASortedArray.Solution solution = new _977_SquaresOfASortedArray().new Solution();
        int[] input = {-4, -1, 0, 3, 10};
        int[] rst = solution.sortedSquares(input);
        int[] expect = {0, 1, 9, 16, 100};
        Assert.assertTrue(ArrayUtil.equal(expect, rst));
    }

    @Test
    public void test01() {
        _977_SquaresOfASortedArray.Solution solution = new _977_SquaresOfASortedArray().new Solution();
        int[] input = {-7,-3,2,3,11};
        int[] rst = solution.sortedSquares(input);
        int[] expect = {4,9,9,49,121};
        Assert.assertTrue(ArrayUtil.equal(expect, rst));
    }

    @Test
    public void test02() {
        _977_SquaresOfASortedArray.Solution solution = new _977_SquaresOfASortedArray().new Solution();
        int[] input = {-4,-1,0,3,10};
        int[] rst = solution.sortedSquares(input);
        int[] expect = {0,1,9,16,100};
        Assert.assertTrue(ArrayUtil.equal(expect, rst));
    }
    @Test
    public void test03() {
        _977_SquaresOfASortedArray.Solution solution = new _977_SquaresOfASortedArray().new Solution();
        int[] input = {-4,-1,0,3,10};
        int[] rst = solution.sortedSquares(input);
        int[] expect = {0,1,9,16,100};
        Assert.assertTrue(ArrayUtil.equal(expect, rst));
    }
}