package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0287_DuplicateFinderTest extends TestCase {
    @Test
    public void test00() {
        _0287_DuplicateFinder.Solution solution = new _0287_DuplicateFinder().new Solution();
        int duplicate = solution.findDuplicate(new int[]{1, 3, 4, 2, 2});
        Assert.assertEquals(2, duplicate);
    }

    @Test
    public void test01() {
        _0287_DuplicateFinder.Solution solution = new _0287_DuplicateFinder().new Solution();
        int duplicate = solution.findDuplicate(new int[]{3, 1, 3, 4, 2});
        Assert.assertEquals(3, duplicate);
    }

    @Test
    public void test02() {
        _0287_DuplicateFinder.Solution solution = new _0287_DuplicateFinder().new Solution();
        int duplicate = solution.findDuplicate(new int[]{3, 3, 3, 3, 3});
        Assert.assertEquals(3, duplicate);
    }

}