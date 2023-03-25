package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

/**
 * medium
 */
public class _0002_AddTwoNums {
    /**
     * 麻烦的点：
     * 1 末位开始运算，但是末位是最后一位，用递归的方式好一些
     * 2 长短不一时，该如何保持在同一位（个十百）
     * 3 相加最后一位记得往上加
     * 最终发现审题审错了，头是个位，尾是最高位
     * 1 遍历
     * added=0;
     * if (first== null && second == null && added = 0) {
     * return dummy.next;
     * }
     * if (first == null && second == null) {
     * tail.next = new Node(added);
     * return dummy.next;
     * }
     * add = 0;
     * cur ;
     * if (first == null) {
     * cur = first.val;
     * } else if (second == null {
     * cur = second.val;
     * } else {
     * cur = first.val+second.val
     * }
     * sum= added+cur;
     * added = sum/10;
     * cur = sum%10;
     * if (first!=null) {
     * first =first.next;
     * }
     * if (second!=null) {
     * second=second.next;
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            int added = 0;
            while (l1 != null || l2 != null || added != 0) {
                if (l1 == null && l2 == null) {
                    tail.next = new ListNode(added);
                    return dummy.next;
                }
                int cur;
                if (l1 == null) {
                    cur = l2.val;
                } else if (l2 == null) {
                    cur = l1.val;
                } else {
                    cur = l1.val + l2.val;
                }
                int sum = added + cur;
                cur = sum % 10;
                added = sum / 10;
                ListNode listNode = new ListNode(cur);
                tail.next = listNode;
                tail = listNode;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            return dummy.next;
        }
    }

    class Solution00 {
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
