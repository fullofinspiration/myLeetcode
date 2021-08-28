package com.fullofinspiration.github.knifeoffer;

import com.fullofinspiration.github.tool.ListNode;

public class KthNodeFromEnd {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode pre = head;
            while (k-- > 0) {
                head = head.next;
            }
            while (head != null) {
                head = head.next;
                pre = pre.next;
            }
            return pre;
        }
    }
}
