package com.fullofinspiration.github.leetcode;

public class AddTwoNum {

  public static void main(String[] args) {
    ListNode listNode = new ListNode(2);
    ListNode listNode1 = new ListNode(4);
    ListNode listNode2 = new ListNode(3);
    ListNode listNode3 = new ListNode(5);
    ListNode listNode4 = new ListNode(6);
    ListNode listNode5 = new ListNode(4);
    listNode.next = listNode1;
    listNode1.next = listNode2;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    ListNode listNode6 = addTwoNumbers(listNode,listNode3);
    System.out.println(listNode6);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int superfluous = 0;
    ListNode firstNode = null;
    ListNode prevNode = null;
    while (l1 != null || l2 != null) {
      int val;
      if (l1 != null && l2 != null) {
        val = l1.val + l2.val;
      } else if (l1 != null) {
        val = l1.val;
      } else  {
        val = l2.val;
      }
      val += superfluous;
      if (val >=10) {
        val -= 10;
        superfluous = 1;
      } else {
        superfluous = 0;
      }
      ListNode curNode = new ListNode(val);
      if (firstNode == null) {
        firstNode = curNode;
        prevNode = curNode;
      } else {
        prevNode.next = curNode;
        prevNode = curNode;
      }
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (superfluous != 0) {
      ListNode listNode = new ListNode(1);
      prevNode.next = listNode;
    }
    return firstNode;
  }

}

class ListNode {

  int val;
  ListNode next;

  public ListNode(int val) {
    this.val = val;
  }
}

