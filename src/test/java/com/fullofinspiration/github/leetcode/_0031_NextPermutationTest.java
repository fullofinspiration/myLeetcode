package com.fullofinspiration.github.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class _0031_NextPermutationTest {
  private static final _0031_NextPermutation.Solution SOLUTION = new _0031_NextPermutation().new Solution();

  @Test
  public void test00() {
    int[] ints = {1, 2, 3};
    SOLUTION.nextPermutation(ints);
    Assert.assertEquals(Arrays.toString(new int[]{1, 3, 2}), Arrays.toString(ints));
  }

  @Test
  public void test01() {
    int[] ints = {3, 2, 1};
    SOLUTION.nextPermutation(ints);
    Assert.assertEquals(Arrays.toString(new int[]{1, 2, 3}), Arrays.toString(ints));
  }

  @Test
  public void test02() {
    int[] ints = {1, 1, 5};
    SOLUTION.nextPermutation(ints);
    Assert.assertEquals(Arrays.toString(new int[]{1, 5, 1}), Arrays.toString(ints));
  }

  @Test
  public void test03() {
    int[] ints = {1};
    SOLUTION.nextPermutation(ints);
    Assert.assertEquals(Arrays.toString(new int[]{1}), Arrays.toString(ints));
  }

  @Test
  public void test04() {
    int[] ints = {1, 3, 2};
    SOLUTION.nextPermutation(ints);
    Assert.assertEquals(Arrays.toString(new int[]{2, 1, 3}), Arrays.toString(ints));
  }

  @Test
  public void test05() {
    int[] ints = {1, 5, 1};
    SOLUTION.nextPermutation(ints);
    Assert.assertEquals(Arrays.toString(new int[]{5, 1, 1}), Arrays.toString(ints));
  }
  @Test
  public void test06() {
    int[] ints = {6,9,8,5,4};
    SOLUTION.nextPermutation(ints);
    Assert.assertEquals(Arrays.toString(new int[]{8,4,5,6,9}), Arrays.toString(ints));
  }
}