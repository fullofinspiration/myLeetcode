package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0023_MergeKSortedLists {
  //一把过，我真是太牛逼了，就是运行时间长了点
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists ==null || lists.length == 0) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    handleMergeKLists(dummy,lists);
    return dummy.next;
  }

  private void handleMergeKLists(ListNode head, ListNode[] lists) {
    ListNode minListNode = null;
    int minListNodeIndex=0;
    for (int i=0;i<lists.length;i++) {
      if (lists[i] != null) {
        if (minListNode == null || minListNode.val > lists[i].val) {
          minListNode = lists[i];
          minListNodeIndex = i;
        }
      }
    }
    if (minListNode == null) {
      return;
    }
    head.next = minListNode;
    head = minListNode;
    minListNode = minListNode.next;
    lists[minListNodeIndex] = minListNode;
    handleMergeKLists(head,lists);
  }
}
