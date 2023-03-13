package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ArrayUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0347_TopKFrequentElementsTest extends TestCase {
    @Test
    public void test00() {
        _0347_TopKFrequentElements.Solution solution = new _0347_TopKFrequentElements().new Solution();
        int[] actual = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        int[] expect = new int[]{1, 2};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0347_TopKFrequentElements.Solution solution = new _0347_TopKFrequentElements().new Solution();
        int[] actual = solution.topKFrequent(new int[]{1}, 1);
        int[] expect = new int[]{1};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0347_TopKFrequentElements.Solution solution = new _0347_TopKFrequentElements().new Solution();
        int[] actual = solution.topKFrequent(new int[]{1, 2}, 2);
        int[] expect = new int[]{1, 2};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test03() {
        _0347_TopKFrequentElements.Solution solution = new _0347_TopKFrequentElements().new Solution();
        int[] actual = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        int[] expect = new int[]{1, 2};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }
    @Test
    public void test04() {
        _0347_TopKFrequentElements.Solution solution = new _0347_TopKFrequentElements().new Solution();
        int[] actual = solution.topKFrequent(new int[]{-4,1,-1,2,-1,2,3}, 2);
        int[] expect = new int[]{-1, 2};
        boolean equal = ArrayUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }
}