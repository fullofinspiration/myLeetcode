package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.leetcode._1249_MinimumRemoveToMakeValidParentThese.Solution;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Set;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/28 12:22 PM
 */
public class _1249_MinimumRemoveToMakeValidParentTheseTest extends TestCase {

  private static final Solution SOLUTION = new _1249_MinimumRemoveToMakeValidParentThese().new Solution();

  @Test
  public void test00() {
    String rst = SOLUTION.minRemoveToMakeValid("lee(t(c)o)de)");
    System.out.println(rst);
    Set<String> expected = ImmutableSet.of("lee(t(co)de)", "lee(t(c)ode)", "lee(t(c)o)de");
    Assert.assertTrue(expected.contains(rst));
  }

  @Test
  public void test01() {
    String rst = SOLUTION.minRemoveToMakeValid("a)b(c)d");
    System.out.println(rst);
    Set<String> expected = ImmutableSet.of("ab(c)d");
    Assert.assertTrue(expected.contains(rst));
  }

  @Test
  public void test02() {
    String rst = SOLUTION.minRemoveToMakeValid("))((");
    System.out.println(rst);
    Set<String> expected = ImmutableSet.of("");
    Assert.assertTrue(expected.contains(rst));
  }

  @Test
  public void test03() {
    char[] s = {'a','b'};
    String s1 = Arrays.toString(s);
    System.out.println(s1);
  }
}