package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0083_RemoveDuplicatesFromSortedList {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode pre = head;
            ListNode cur = pre.next;

            while (cur != null) {
                if (cur.val == pre.val) {
                    cur = cur.next;
                    pre.next = cur;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            return head;
        }
    }
}
