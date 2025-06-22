package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0003_LongestCommonPrefixTest {


    @Test
    public void testLongestCommonPrefix01() {
        _0003_LongestCommonPrefix.Solution solution = init();

        int length = solution.lengthOfLongestSubstring("abcabcbb");
        assertEquals(3, length);
    }

    @Test
    public void testLongestCommonPrefix02() {
        _0003_LongestCommonPrefix.Solution solution = init();
        int length = solution.lengthOfLongestSubstring("bbbbb");
        assertEquals(1, length);
    }

    @Test
    public void testLongestCommonPrefix03() {
        _0003_LongestCommonPrefix.Solution solution = init();
        int length = solution.lengthOfLongestSubstring("");
        assertEquals(0, length);
    }

    @Test
    public void testLongestCommonPrefix04() {
        _0003_LongestCommonPrefix.Solution solution = init();
        int length = solution.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, length);
    }


    private static _0003_LongestCommonPrefix.Solution init() {
        return new _0003_LongestCommonPrefix().new Solution();
    }


}