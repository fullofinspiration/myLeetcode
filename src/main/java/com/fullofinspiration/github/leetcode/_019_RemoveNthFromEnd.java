package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

/**
 * 只需遍历一遍，一开始我写的时候是遍历两遍，这个需要记住两点，一个是早点的节点和晚点
 * 的节点之间间隔和和要确定的两个节点（第一个节点为要删除的节点的前一个节点）索引的关系，
 * 第二点是删除的节点是否是第一个节点
 */
public class _019_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
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


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        //System.out.println(listNode2.next == null);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        _019_RemoveNthFromEnd removeNthFromEnd = new _019_RemoveNthFromEnd();
        System.out.println(removeNthFromEnd.removeNthFromEnd(listNode1, 2));
    }
}

