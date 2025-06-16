package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ArrayUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0075_SortColorsTest {
    private final _0075_SortColors.Solution SOLUTION = new _0075_SortColors().new Solution();

    @Test
    public void test00() {
        int[] nums = new int[]{
                2, 0, 2, 1, 1, 0
        };
        SOLUTION.sortColors(nums);
        int[] expect = new int[]{0, 0, 1, 1, 2, 2};
        boolean equal = ArrayUtil.equal(expect, nums);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        int[] nums = new int[]{
                2, 0, 1
        };
        SOLUTION.sortColors(nums);
        int[] expect = new int[]{0, 1, 2};
        boolean equal = ArrayUtil.equal(expect, nums);
        Assert.assertTrue(equal);
    }


}