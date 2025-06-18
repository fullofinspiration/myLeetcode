package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.leetcode._0004_MedianOfTwoSortedArrays.Solution;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/12 8:47 PM
 */
public class _0004_MedianOfTwoSortedArraysTest extends TestCase {

  private static final double DELTA = 0.000001;
  private static final Solution MEDIAN_OF_TWO_SORTED_ARRAYS = new _0004_MedianOfTwoSortedArrays().new Solution();

  @Test
  public void test00() {
    int[] first = {1, 3};
    int[] second = {2};
    double medianSortedArrays = MEDIAN_OF_TWO_SORTED_ARRAYS.findMedianSortedArrays(first, second);
    Assert.assertEquals(2, medianSortedArrays, DELTA);
  }

  @Test
  public void test01() {
    int[] first = {1, 2};
    int[] second = {3, 4};
    double medianSortedArrays = MEDIAN_OF_TWO_SORTED_ARRAYS.findMedianSortedArrays(first, second);
    Assert.assertEquals(2.5, medianSortedArrays, DELTA);
  }

  @Test
  public void test02() {
    int[] first = {0, 0};
    int[] second = {0, 0};
    double medianSortedArrays = MEDIAN_OF_TWO_SORTED_ARRAYS.findMedianSortedArrays(first, second);
    Assert.assertEquals(0, medianSortedArrays, DELTA);
  }

  @Test
  public void test03() {
    int[] first = {};
    int[] second = {1};
    double medianSortedArrays = MEDIAN_OF_TWO_SORTED_ARRAYS.findMedianSortedArrays(first, second);
    Assert.assertEquals(1, medianSortedArrays, DELTA);
  }

  @Test
  public void test04() {
    int[] first = {2};
    int[] second = {};
    double medianSortedArrays = MEDIAN_OF_TWO_SORTED_ARRAYS.findMedianSortedArrays(first, second);
    Assert.assertEquals(2, medianSortedArrays, DELTA);
  }
  @Test
  public void test05() {
    int[] first = {2,3};
    int[] second = {1};
    double medianSortedArrays = MEDIAN_OF_TWO_SORTED_ARRAYS.findMedianSortedArrays(first, second);
    Assert.assertEquals(2, medianSortedArrays, DELTA);
  }
}