package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _0206_ReverseLinkedList {


    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode();
            while (head != null) {
                ListNode tmp = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = tmp;
            }
            return dummy.next;
        }
    }

    class Solution00 {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(0);
            while (head != null) {
                ListNode temp = head.next;
                head.next = dummy.next;
                dummy.next = head;
                head = temp;
            }
            return dummy.next;
        }
    }
}
