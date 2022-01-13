package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.leetcode._0011_ContainerMostWater.Solution;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/13 9:51 PM
 */
public class _0011_ContainerMostWaterTest extends TestCase {

 private static final Solution SOLUTION = new _0011_ContainerMostWater().new Solution();

 @Test
 public void test00() {
  int[] input = {1,8,6,2,5,4,8,3,7};
  int target = SOLUTION.maxArea(input);
  Assert.assertEquals(49, target);
 }
 @Test
 public void test01() {
  int[] input = {1,1};
  int target = SOLUTION.maxArea(input);
  Assert.assertEquals(1, target);
 }
}