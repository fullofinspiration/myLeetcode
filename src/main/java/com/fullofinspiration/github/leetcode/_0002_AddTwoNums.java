package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

/**
 * medium
 */
public class _0002_AddTwoNums {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode curNode = dummy;
            int preValue = 0;
            while (l1 != null || l2 != null) {
                int res;
                if (l2 == null) {
                    res = l1.val;
                    l1 = l1.next;
                } else if (l1 == null) {
                    res = l2.val;
                    l2 = l2.next;
                } else {
                    res = l1.val + l2.val;
                    l1 = l1.next;
                    l2 = l2.next;
                }
                res += preValue;
                if (res >= 10) {
                    preValue = 1;
                    res -= 10;
                } else {
                    preValue = 0;
                }
                ListNode newNode = new ListNode(res);
                curNode.next = newNode;
                curNode = newNode;
            }
            if (preValue != 0) {
                curNode.next = new ListNode(preValue);
            }
            return dummy.next;
        }
    }
}
