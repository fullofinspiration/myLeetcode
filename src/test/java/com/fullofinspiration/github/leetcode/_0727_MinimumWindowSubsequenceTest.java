package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0727_MinimumWindowSubsequenceTest {
    private static final _0727_MinimumWindowSubsequence.Solution SOLUTION =
            new _0727_MinimumWindowSubsequence().new Solution();

    @Test
    public void test00() {
        String s = SOLUTION.minWindow("abcdebdde", "bde");
        assertEquals( "bcde", s);
    }

    @Test
    public void test01() {
        System.out.println(1 &1);
        System.out.println((~1) &1);
    }

}