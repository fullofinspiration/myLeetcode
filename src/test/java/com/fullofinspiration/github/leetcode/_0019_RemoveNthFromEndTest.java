package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0019_RemoveNthFromEndTest extends TestCase {
  @Test
  public void test00() {
    ListNode input = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
    _0019_RemoveNthFromEnd.Solution solution = new _0019_RemoveNthFromEnd().new Solution();
    ListNode rst = solution.removeNthFromEnd(input, 2);
    ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 5});
    boolean equal = ListNodeUtil.equal(expect, rst);
    Assert.assertTrue(equal);
  }

  @Test
  public void test01() {
    ListNode input = ListNodeUtil.buildListNode(new int[]{1});
    _0019_RemoveNthFromEnd.Solution solution = new _0019_RemoveNthFromEnd().new Solution();
    ListNode rst = solution.removeNthFromEnd(input, 1);
    ListNode expect = ListNodeUtil.buildListNode(new int[]{});
    boolean equal = ListNodeUtil.equal(expect, rst);
    Assert.assertTrue(equal);
  }
  @Test
  public void test02() {
    ListNode input = ListNodeUtil.buildListNode(new int[]{1,2});
    _0019_RemoveNthFromEnd.Solution solution = new _0019_RemoveNthFromEnd().new Solution();
    ListNode rst = solution.removeNthFromEnd(input, 1);
    ListNode expect = ListNodeUtil.buildListNode(new int[]{1});
    boolean equal = ListNodeUtil.equal(expect, rst);
    Assert.assertTrue(equal);
  }
}