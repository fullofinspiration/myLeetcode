package com.fullofinspiration.github.leetcode;

public class SwapPairs {
  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    listNode1.next= listNode2;
    listNode2.next = listNode3;
    listNode3.next=listNode4;
    swapPairs(listNode1);
  }
  public static ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode curHead = dummy;
    while (head != null) {
      ListNode first = head, second = head.next;
      if (second == null) {
        curHead.next = head;
        curHead = head;
        break;
      }
      curHead.next = second;
      head = second.next;
      second.next = first;
      curHead = first;
    }
    curHead.next = null;
    return dummy.next;
  }
}
