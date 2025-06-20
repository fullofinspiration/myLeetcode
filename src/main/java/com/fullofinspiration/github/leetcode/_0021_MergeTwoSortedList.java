package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0021_MergeTwoSortedList {
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode prev = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    prev = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    prev = l2;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                prev.next = l1;
            } else {
                prev.next = l2;
            }
            return dummy.next;
        }
    }

    public class Solution01 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public class Solution00 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy4Head = new ListNode(0);
            ListNode tail = dummy4Head;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    tail.next = l2;
                    tail = l2;
                    l2 = l2.next;
                } else {
                    tail.next = l1;
                    tail = l1;
                    l1 = l1.next;
                }
            }
            if (l1 != null) {
                tail.next = l1;
            }
            if (l2 != null) {
                tail.next = l2;
            }
            return dummy4Head.next;
        }
    }
}
