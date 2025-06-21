package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0234_FindPalindrome {
    /**
     * https://leetcode.cn/problems/palindrome-linked-list/solutions/2952645/o1-kong-jian-zuo-fa-xun-zhao-zhong-jian-rv0f3
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode mid = findMid(head);
            ListNode head2 = reverse(mid);
            while (head2 != null) {
                if (head.val != head2.val) {
                    return false;
                }
                head = head.next;
                head2 = head2.next;
            }
            return true;
        }

        private ListNode reverse(ListNode cur) {
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        private ListNode findMid(ListNode head) {
            ListNode slow = head, quick = head;
            while (quick!=null&&quick.next != null) {
                slow = slow.next;
                quick = quick.next.next;
            }
            return slow;
        }
    }
}
