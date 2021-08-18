package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0021_MergeTwoSortedList {
    public class Solution {
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
