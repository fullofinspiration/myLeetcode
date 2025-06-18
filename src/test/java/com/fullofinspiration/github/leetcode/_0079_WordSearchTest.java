package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0079_WordSearchTest {
    @Test
    public void test00() {
        _0079_WordSearch.Solution solution = new _0079_WordSearch().new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        boolean ret = solution.exist(board, "ABCB");
        Assert.assertFalse(ret);
    }
}