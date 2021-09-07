package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class _0165_CompareVersionNumbersTest {
    _0165_CompareVersionNumbers.Solution solution = new _0165_CompareVersionNumbers().new Solution();

    @Test
    public void test00() {
        int version = solution.compareVersion("1.01", "1.001");
        assertEquals(0,version);
    }
    @Test
    public void test01() {
        int version = solution.compareVersion("1.0", "1.0.0");
        assertEquals(0,version);
    }
    @Test
    public void test02() {
        int version = solution.compareVersion("0.1", "1.1");
        assertEquals(-1,version);
    }

    @Test
    public void test03() {
        int version = solution.compareVersion("1.0.1", "1");
        assertEquals(1,version);
    }
    @Test
    public void test04() {
        int version = solution.compareVersion("7.5.2.4", "7.5.3");
        assertEquals(-1,version);
    }

}