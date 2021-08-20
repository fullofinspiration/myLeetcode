package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _0020_GenerateParenthesisTests {
  private static final   _0020_GenerateParenthesis.Solution SOLUTION = new _0020_GenerateParenthesis().new Solution();

    @Test
    public void test00() {
      assertTrue(SOLUTION.isValid("()"));
    }

  @Test
  public void test01() {
    assertTrue(SOLUTION.isValid("()[]{}"));
  }

  @Test
  public void test02() {
    assertFalse(SOLUTION.isValid("(]"));
  }

  @Test
  public void test03() {
    assertFalse(SOLUTION.isValid("([)]"));
  }


  @Test
  public void test04() {
    assertTrue(SOLUTION.isValid("{[]}"));
  }

}