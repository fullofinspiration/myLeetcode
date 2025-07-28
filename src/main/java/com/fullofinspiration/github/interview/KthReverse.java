package com.fullofinspiration.github.interview;

import com.fullofinspiration.github.tool.ListNode;

/**
 * k个一组反转
 * 1 使用头插法：1）保存tail节点 2 当前遍历节点插入 3 更新当前节点
 */
public class KthReverse {
    class Solution {
        /**
         * k从1开始
         * 1,2,3 k=1,j=2
         * 2,1,3
         */
        public ListNode reverseK(ListNode node, int k, int j) {
            ListNode dummy = new ListNode();
            dummy.next = node;
            ListNode head = dummy;
            int i = 0;
            while (++i < k) {
                head = head.next;
            }
            ListNode tail = head.next;
            ListNode cur = tail;
            int count = 0;
            while (count++ <= j - k) {
                ListNode temp = cur.next;
                cur.next = head.next;
                head.next = cur;
                cur = temp;
            }
            tail.next = cur;
            return dummy.next;

        }
    }
}
