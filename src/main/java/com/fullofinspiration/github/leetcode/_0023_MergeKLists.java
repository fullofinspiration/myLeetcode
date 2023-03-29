package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.Arrays;
import java.util.List;


public class _0023_MergeKLists {
  /**
   * 参照solution00
   */
  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null|| lists.length ==0) {
        return null;
      }
      List<ListNode> listNodes = Arrays.asList(lists);
      return mergeKLists(listNodes);
    }

    public ListNode mergeKLists(List<ListNode> lists) {
      if (lists.size() == 0) {
        return null;
      }
      if (lists.size() == 1) {
        return lists.get(0);
      }
      if (lists.size() == 2) {
        return mergeTwoLists(lists.get(0), lists.get(1));
      }
      return mergeTwoLists(mergeKLists(lists.subList(0, lists.size() / 2)), mergeKLists(lists.subList(lists.size() / 2, lists.size())));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode();
      ListNode cur = dummy;
      while (l1 != null || l2 != null) {
        if (l1 == null) {
          cur.next = l2;
          return dummy.next;
        }
        if (l2 == null) {
          cur.next = l1;
          return dummy.next;
        }
        if (l1.val < l2.val) {
          cur.next = l1;
          cur = l1;
          l1 = l1.next;
        } else {
          cur.next = l2;
          cur = l2;
          l2 = l2.next;
        }
      }
      return dummy.next;
    }
  }

  class Solution01 {
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }
      ListNode cur = null;
      for (ListNode list : lists) {
        cur = mergeTwoLists(cur, list);
      }
      return cur;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode();
      ListNode cur = dummy;
      while (l1 != null || l2 != null) {
        if (l1 == null) {
          cur.next = l2;
          return dummy.next;
        }
        if (l2 == null) {
          cur.next = l1;
          return dummy.next;
        }
        if (l1.val < l2.val) {
          cur.next = l1;
          cur = l1;
          l1 = l1.next;
        } else {
          cur.next = l2;
          cur = l2;
          l2 = l2.next;
        }
      }
      return dummy.next;
    }
  }

  class Solution00 {
    public ListNode mergeKLists(List<ListNode> listNodes) {
      if (listNodes.isEmpty())
        return null;
      if (listNodes.size() == 1)
        return listNodes.get(0);
      if (listNodes.size() == 2)
        return mergeTwoLists(listNodes.get(0), listNodes.get(1));
      return mergeTwoLists(mergeKLists(listNodes.subList(0, listNodes.size() / 2)),
              mergeKLists(listNodes.subList(listNodes.size() / 2, listNodes.size())));
    }

    /**
     * 值得注意的是n个链表排序而不是两个链表排序，
     * 这里先写两个链表排序方法，然后写n个链表排序，
     * 里面又嵌套了两个出口，也就是调用mergeTwoLists方法相当于也是一个递归方法，
     * 这个方式好奇特，以前从没有遇到过
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null)
        return l2;
      if (l2 == null)
        return l1;
      ListNode preNode = null, head = null;
      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          if (preNode == null && head == null) {
            preNode = l1;
            head = l1;
          } else {
            preNode.next = l1;
            preNode = l1;
          }

          l1 = l1.next;
        } else {
          if (preNode == null && head == null) {
            preNode = l2;
            head = l2;
          } else {
            preNode.next = l2;
            preNode = l2;
          }

          l2 = l2.next;
        }
      }
      if (l1 == null)
        preNode.next = l2;
      if (l2 == null)
        preNode.next = l1;
      return head;
    }
  }
}
