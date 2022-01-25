package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.leetcode._1049_Weight4LastStone.Solution;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/24 7:25 PM
 */
public class _1049_Weight4LastStoneTest extends TestCase {

  private static final Solution solution = new _1049_Weight4LastStone().new Solution();

  @Test
  public void test00() {
    int lastStoneWeightII = solution.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
    Assert.assertEquals(1, lastStoneWeightII);
  }

  @Test
  public void test01() {
    int lastStoneWeightII = solution.lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
    Assert.assertEquals(5, lastStoneWeightII);
  }

  @Test
  public void test02() {
    int lastStoneWeightII = solution.lastStoneWeightII(new int[]{1, 2});
    Assert.assertEquals(1, lastStoneWeightII);
  }
}