package com.fullofinspiration.github.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0322_CoinChangesTest {

    @Test
    public void test00() {
        _0322_CoinChanges.Solution solution = new _0322_CoinChanges().new Solution();
        int[] ints = {1, 2, 5};
        int rst = solution.coinChange(ints, 11);
        assertEquals(3, rst);
    }

    @Test
    public void test01() {
        _0322_CoinChanges.Solution solution = new _0322_CoinChanges().new Solution();
        int[] ints = {2};
        int rst = solution.coinChange(ints, 3);
        assertEquals(-1, rst);
    }

    @Test
    public void test02() {
        _0322_CoinChanges.Solution solution = new _0322_CoinChanges().new Solution();
        int[] ints = {1};
        int rst = solution.coinChange(ints, 0);
        assertEquals(0, rst);
    }

    @Test
    public void test03() {
        _0322_CoinChanges.Solution solution = new _0322_CoinChanges().new Solution();
        int[] ints = {1};
        int rst = solution.coinChange(ints, 1);
        assertEquals(1, rst);
    }

    @Test
    public void test04() {
        _0322_CoinChanges.Solution solution = new _0322_CoinChanges().new Solution();
        int[] ints = {1};
        int rst = solution.coinChange(ints, 2);
        assertEquals(2, rst);
    }

    @Test
    public void test05() {
        _0322_CoinChanges.Solution solution = new _0322_CoinChanges().new Solution();
        int[] ints = {1, 2, 5};
        int rst = solution.coinChange(ints, 4);
        assertEquals(2, rst);
    }

    @Test
    public void test06() {
        _0322_CoinChanges.Solution solution = new _0322_CoinChanges().new Solution();
        int[] ints = {186, 419, 83, 408};
        int rst = solution.coinChange(ints, 6249);
        assertEquals(20, rst);
    }

    @Test
    public void test07() {
        _0322_CoinChanges.Solution solution = new _0322_CoinChanges().new Solution();
        int[] ints = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        int rst = solution.coinChange(ints, 9864);
        assertEquals(24, rst);
    }
}
