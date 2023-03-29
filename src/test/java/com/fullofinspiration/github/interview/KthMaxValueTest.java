package com.fullofinspiration.github.interview;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class KthMaxValueTest extends TestCase {
  @Test
  public void test00() {
    _0215_KthMaxValue.Solution kthMaxValue = new _0215_KthMaxValue().new Solution();
    int kth = kthMaxValue.findKthLargest(new int[]{5, 7, 8, 6, 4}, 1);
    Assert.assertEquals(8, kth);
  }

  @Test
  public void test01() {
    _0215_KthMaxValue.Solution kthMaxValue = new _0215_KthMaxValue().new Solution();
    int kth = kthMaxValue.findKthLargest(new int[]{5, 7, 8, 6, 4}, 2);
    Assert.assertEquals(7, kth);
  }

  @Test
  public void test02() {
    _0215_KthMaxValue.Solution kthMaxValue = new _0215_KthMaxValue().new Solution();
    int kth = kthMaxValue.findKthLargest(new int[]{5, 7, 8, 6, 4}, 3);
    Assert.assertEquals(6, kth);
  }

  @Test
  public void test03() {
    _0215_KthMaxValue.Solution kthMaxValue = new _0215_KthMaxValue().new Solution();
    int kth = kthMaxValue.findKthLargest(new int[]{5, 7, 8, 6, 4}, 3);
    Assert.assertEquals(6, kth);
  }

  @Test
  public void test04() {
    _0215_KthMaxValue.Solution kthMaxValue = new _0215_KthMaxValue().new Solution();
    int kth = kthMaxValue.findKthLargest(new int[]{5, 7, 8, 6, 4}, 4);
    Assert.assertEquals(5, kth);
  }

  @Test
  public void test05() {
    _0215_KthMaxValue.Solution kthMaxValue = new _0215_KthMaxValue().new Solution();
    int kth = kthMaxValue.findKthLargest(new int[]{5, 7, 8, 6, 4}, 5);
    Assert.assertEquals(4, kth);
  }
}