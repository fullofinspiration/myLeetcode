package com.fullofinspiration.github.leetcode;

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
    public static void main(String[] args) {
        _0206_ReverseLinkedList reverseLinkedList = new _0206_ReverseLinkedList();
        Solution solution = reverseLinkedList.new Solution();
    }

    class Solution {
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
