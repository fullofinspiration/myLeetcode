package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class _0022_GenerateParenthesisTest {

    @Test
    public void test00() {
        _0022_GenerateParenthesis.Solution solution = new _0022_GenerateParenthesis().new Solution();
        List<String> rst = solution.generateParenthesis(3);
        ImmutableList<String> expect = ImmutableList.of("((()))", "(()())", "(())()", "()(())", "()()()");
        boolean equal = ListUtil.equal(expect, rst);
        assertTrue(equal);
    }

    @Test
    public void test01() {
        _0022_GenerateParenthesis.Solution solution = new _0022_GenerateParenthesis().new Solution();
        List<String> rst = solution.generateParenthesis(1);
        ImmutableList<String> expect = ImmutableList.of("()");
        boolean equal = ListUtil.equal(expect, rst);
        assertTrue(equal);
    }
}