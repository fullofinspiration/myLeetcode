package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0455_AssignCookiesTest extends TestCase {

    @Test
    public void test00() {
        _0455_AssignCookies.Solution solution = new _0455_AssignCookies().new Solution();
        int rst = solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        Assert.assertEquals(1, rst);
    }

    @Test
    public void test01() {
        _0455_AssignCookies.Solution solution = new _0455_AssignCookies().new Solution();
        int rst = solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2,3});
        Assert.assertEquals(2, rst);
    }

}