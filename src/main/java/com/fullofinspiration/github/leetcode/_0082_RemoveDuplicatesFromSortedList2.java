package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0082_RemoveDuplicatesFromSortedList2 {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode fakeHead = new ListNode();
            fakeHead.next = head;
            ListNode pre = fakeHead;
            ListNode cur = head;
            while (cur != null) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                if (pre.next == cur) {
                    pre = cur;
                } else {
                    pre.next = cur.next;
                }
                cur = cur.next;
            }
            return fakeHead.next;
        }
    }

    class Solution01 {
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
