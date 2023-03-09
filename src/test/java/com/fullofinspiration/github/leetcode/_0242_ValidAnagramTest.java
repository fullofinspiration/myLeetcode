package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0242_ValidAnagramTest extends TestCase {

    @Test
    public void test00() {
        _0242_ValidAnagram.Solution solution = new _0242_ValidAnagram().new Solution();
        boolean anagram = solution.isAnagram("anagram", "nagaram");
        Assert.assertTrue(anagram);
    }
    @Test
    public void test01() {
        _0242_ValidAnagram.Solution solution = new _0242_ValidAnagram().new Solution();
        boolean anagram = solution.isAnagram("rat", "car");
        Assert.assertFalse(anagram);
    }
}