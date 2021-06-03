package com.fullofinspiration.github.leetcode;


public class _0019_RemoveNthFromEnd {

  /**
   * 这个方法已经很简便了，但是如果加一个假的头结点，会更好的处理corner case
   * @param head
   * @param n
   * @return
   */
  public static ListNode removeNthFromEnd1(ListNode head,int n) {
    ListNode preRemoveNode = head,lastNode = head;
    while (n >0) {
      lastNode = lastNode.next;
      n--;
    }
    if (lastNode == null) {
      return head.next;
    }
    while (lastNode.next!= null) {
      preRemoveNode = preRemoveNode.next;
      lastNode = lastNode.next;
    }
    preRemoveNode.next = preRemoveNode.next.next;
    return head;
  }
  public static ListNode removeNthFromEnd(ListNode head,int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode preMoveNode = dummy,lastNode=dummy;
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
