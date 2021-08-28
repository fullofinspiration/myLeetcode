package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

/**
 * 只需遍历一遍，一开始我写的时候是遍历两遍，这个需要记住两点，一个是早点的节点和晚点
 * 的节点之间间隔和和要确定的两个节点（第一个节点为要删除的节点的前一个节点）索引的关系，
 * 第二点是删除的节点是否是第一个节点
 */
public class _019_RemoveNthFromEnd {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode later = dummy;
            for (int i = 0; i < n; i++) {
                later = later.next;
            }

            ListNode pre = dummy;
            while (later.next != null) {
                later = later.next;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return dummy.next;
        }
    }

    public ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode cur = head, afterN = head;
        while (n-- != 0)
            afterN = afterN.next;
        //判断删除的是否是首个节点
        if (afterN == null)
            return head.next;
        while (afterN.next != null) {
            cur = cur.next;
            afterN = afterN.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}

