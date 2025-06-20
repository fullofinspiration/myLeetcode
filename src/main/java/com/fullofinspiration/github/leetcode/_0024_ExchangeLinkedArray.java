package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0024_ExchangeLinkedArray {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode cur = head;
            ListNode prev = dummy;

            while (cur != null) {
                if (cur.next == null) {
                    prev.next = cur;
                    break;
                }
                prev.next = cur.next;
                prev = cur;
                ListNode next = cur.next.next;
                cur.next.next = cur;
                cur.next = null;
                cur = next;
            }
            return dummy.next;
        }
    }
}
