package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class _0051_NQueueTest {
    @Test
    public void test00() {
        _0051_NQueue.Solution solution = new _0051_NQueue().new Solution();
        List<List<String>> actual = solution.solveNQueens(4);
        List<String> expect1 = ImmutableList.of(".Q..", "...Q", "Q...", "..Q.");
        List<String> expect2 = ImmutableList.of("..Q.", "Q...", "...Q", ".Q..");
        List<List<String>> expects = ImmutableList.of(expect1, expect2);
        boolean equal = ListUtil.equalV2(expects, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0051_NQueue.Solution solution = new _0051_NQueue().new Solution();
        List<List<String>> actual = solution.solveNQueens(1);
        List<String> expect1 = ImmutableList.of("Q");
        List<List<String>> expects = ImmutableList.of(expect1);
        boolean equal = ListUtil.equalV2(expects, actual);
        Assert.assertTrue(equal);
    }
}