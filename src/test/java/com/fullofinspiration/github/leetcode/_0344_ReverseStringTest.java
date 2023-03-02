package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0344_ReverseStringTest extends TestCase {
    @Test
    public void test00() {
        _0344_ReverseString.Solution solution = new _0344_ReverseString().new Solution();
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(input);
        char[] expect = new char[]{'o','l','l','e','h'};
        Assert.assertEquals(Arrays.toString(expect), Arrays.toString(input));
    }

    @Test
    public void test01() {
        _0344_ReverseString.Solution solution = new _0344_ReverseString().new Solution();
        char[] input = new char[]{'H','a','n','n','a','h'};
        solution.reverseString(input);
        char[] expect = new char[]{'h','a','n','n','a','H'};
        Assert.assertEquals(Arrays.toString(expect), Arrays.toString(input));
    }

}