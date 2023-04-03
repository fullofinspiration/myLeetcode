package com.fullofinspiration.github.interview;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0334_IncreasingTripletSubsequenceTest extends TestCase {
  @Test
  public void test00() {
    _0334_IncreasingTripletSubsequence.Solution solution = new _0334_IncreasingTripletSubsequence().new Solution();
    boolean exist = solution.increasingTriplet(new int[]{1, 2, 3, 4, 5});
    Assert.assertTrue(exist);
  }

  @Test
  public void test01() {
    _0334_IncreasingTripletSubsequence.Solution solution = new _0334_IncreasingTripletSubsequence().new Solution();
    boolean exist = solution.increasingTriplet(new int[]{5, 4, 3, 2, 1});
    Assert.assertFalse(exist);
  }

  @Test
  public void test02() {
    _0334_IncreasingTripletSubsequence.Solution solution = new _0334_IncreasingTripletSubsequence().new Solution();
    boolean exist = solution.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6});
    Assert.assertTrue(exist);
  }
  @Test
  public void test03() {
    _0334_IncreasingTripletSubsequence.Solution solution = new _0334_IncreasingTripletSubsequence().new Solution();
    boolean exist = solution.increasingTriplet(new int[]{1,1,1});
    Assert.assertFalse(exist);
  }
}