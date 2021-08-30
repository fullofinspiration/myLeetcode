package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0082_RemoveDuplicatesFromSortedList2 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cursor = pre.next;
            Integer skipped = null;
            while (cursor != null) {
                if (skipped != null && cursor.val == skipped) {
                    cursor = cursor.next;
                } else if (cursor.next == null) {
                    pre.next = cursor;
                    return dummy.next;
                } else if (cursor.val == cursor.next.val) {
                    skipped = cursor.val;
                    cursor = cursor.next;
                } else {
                    skipped = null;
                    pre.next = cursor;
                    pre = cursor;
                    cursor = cursor.next;
                }
            }
            pre.next = null;
            return dummy.next;
        }
    }
}
