package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0003_LongestCommonPrefixTest {

    private static final _0003_LongestCommonPrefix.Solution SOLUTION = init();

    @Test
    public void testLongestCommonPrefix01() {
        int length = SOLUTION.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, length);
    }

    @Test
    public void testLongestCommonPrefix02() {
        int length = SOLUTION.lengthOfLongestSubstring("bbbbb");
        assertEquals(1, length);
    }

    @Test
    public void testLongestCommonPrefix03() {
        int length = SOLUTION.lengthOfLongestSubstring("");
        assertEquals(0, length);
    }

    @Test
    public void testLongestCommonPrefix04() {
        int length = SOLUTION.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, length);
    }


    private static _0003_LongestCommonPrefix.Solution init() {
        return new _0003_LongestCommonPrefix().new Solution();
    }


}