package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0150_EvaluateReversePolishNotationTest extends TestCase {
    @Test
    public void test00() {
        _0150_EvaluateReversePolishNotation.Solution solution = new _0150_EvaluateReversePolishNotation().new Solution();
        String[] input = new String[]{"2", "1", "+", "3", "*" };
        int rst = solution.evalRPN(input);
        Assert.assertEquals(9, rst);
    }

    @Test
    public void test01() {
        _0150_EvaluateReversePolishNotation.Solution solution = new _0150_EvaluateReversePolishNotation().new Solution();
        String[] input = new String[]{"4", "13", "5", "/", "+" };
        int rst = solution.evalRPN(input);
        Assert.assertEquals(6, rst);
    }
    @Test
    public void test02() {
        _0150_EvaluateReversePolishNotation.Solution solution = new _0150_EvaluateReversePolishNotation().new Solution();
        String[] input = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int rst = solution.evalRPN(input);
        Assert.assertEquals(22, rst);
    }
}
