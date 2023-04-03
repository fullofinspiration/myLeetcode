package com.fullofinspiration.github.interview;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MaxProfitTest extends TestCase {
  @Test
  public void test00() {
    MaxProfit maxProfit = new MaxProfit();
    int rst = maxProfit.getMaxProfit(new int[]{4, 2, 6, 4}, new int[]{5, 3, 8, 7}, 15);
    Assert.assertEquals(22, rst);

  }

}