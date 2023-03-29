package com.fullofinspiration.github.leetcode;


import com.fullofinspiration.github.tool.ListNode;

public class _0019_RemoveNthFromEnd {
  /**
   * 1 双指针，第一个指针先走i步，两个节点一起走， 直到尾节点下一个节点为null
   * 删除第一个节点下一个节点，返回dummy.next
   * 问题1：终止条件应该是quick.next!=null 而不是slow.next != null
   * 问题2：没有将该值移除，只遍历到该元素
   */
  class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode();
      dummy.next = head;
      ListNode quick = dummy, slow = dummy;
      while (n-- > 0) {
        quick = quick.next;
      }
      while (quick.next != null) {
        quick = quick.next;
        slow = slow.next;
      }
      slow.next = slow.next.next;
      return dummy.next;
    }
  }

  /**
   * 这个方法已经很简便了，但是如果加一个假的头结点，会更好的处理corner case
   *
   * @param head
   * @param n
   * @return
   */
  public static ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode preRemoveNode = head, lastNode = head;
    while (n > 0) {
      lastNode = lastNode.next;
      n--;
    }
    if (lastNode == null) {
      return head.next;
    }
    while (lastNode.next != null) {
      preRemoveNode = preRemoveNode.next;
      lastNode = lastNode.next;
    }
    preRemoveNode.next = preRemoveNode.next.next;
    return head;
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode preMoveNode = dummy, lastNode = dummy;
    while (n > 0) {
      lastNode = lastNode.next;
      n--;
    }
    while (lastNode.next != null) {
      lastNode = lastNode.next;
      preMoveNode = preMoveNode.next;
    }
    preMoveNode.next = preMoveNode.next.next;
    return dummy.next;
  }
}
