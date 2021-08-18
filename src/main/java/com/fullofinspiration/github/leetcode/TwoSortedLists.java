package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class TwoSortedLists {

  //一次过，我真是太牛逼了.
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode curNode = head;
    while (l1 != null && l2 != null) {
      if (l1.val <=l2.val) {
        curNode.next=l1;
        curNode=l1;
        l1=l1.next;
      } else {
        curNode.next=l2;
        curNode = l2;
        l2 = l2.next;
      }
    }
    if (l1 != null) {
      curNode.next = l1;
    } else {
      curNode.next = l2;
    }
    return head.next;
  }
}
