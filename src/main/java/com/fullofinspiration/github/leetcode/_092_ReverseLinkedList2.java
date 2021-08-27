package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _092_ReverseLinkedList2 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            int count = 0;
            while (count + 1 < left) {
                pre = pre.next;
                count++;
            }
            ListNode thePre = pre;
            ListNode curNode = pre.next;
            ListNode rightNodeAfterReverse = curNode;
            while (count < right) {
                ListNode temp = curNode.next;
                curNode.next = thePre.next;
                thePre.next = curNode;
                count++;
                curNode = temp;
            }
            rightNodeAfterReverse.next = curNode;
            return dummy.next;
        }
    }
}
