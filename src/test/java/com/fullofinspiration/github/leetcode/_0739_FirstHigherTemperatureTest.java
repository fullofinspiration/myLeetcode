package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ArrayUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0739_FirstHigherTemperatureTest {
    private static final _0739_FirstHigherTemperature.Solution SOLUTION
            = new _0739_FirstHigherTemperature().new Solution();

    @Test
    public void test00() {
        int[] inputs = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] actual = SOLUTION.dailyTemperatures(inputs);
        int[] expect = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        int[] inputs = new int[]{30,60,90};
        int[] actual = SOLUTION.dailyTemperatures(inputs);
        int[] expect = new int[]{1,1,0};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        int[] inputs = new int[]{30,40,50,60};
        int[] actual = SOLUTION.dailyTemperatures(inputs);
        int[] expect = new int[]{1,1,1,0};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }
}