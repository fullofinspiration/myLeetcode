package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;


public class _019_RemoveNthFromEnd {
    /**
     * 1 新建dummy指针（新建原因是有可能删除头节点）
     * 2 快指针走n+1步
     * 3 快慢指针同时走，走到快指针节点为null
     * 4 慢指针下一个节点删除
     * 5 返回头节点
     * 调试出问题：返回值开始写成了head，应该是dummy.next，因为有可能删除头节点
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode quick = dummy;
            for (int i = 0; i <= n; i++) {
                quick = quick.next;
            }
            ListNode slow = dummy;
            while (quick != null) {
                slow = slow.next;
                quick = quick.next;
            }
            slow.next = slow.next.next;
            return dummy.next;

        }
    }

    /**
     * 使用双指针：
     * 1 先走n步,假如还没走n步就到了队尾(或者走n步，队尾为null也可以)，由于 1<n<=size,唯一原因是队头元素，直接返回队头下一个节点
     * 2 两个一起走
     * 3 快指针指向队尾
     * 4 删除慢指针下一个节点
     * 两遍才调试通过：1 i忘记递增 2 终止条件应该为quick.next不为null 而不是quick不为null，由于终止条件很容易写错，
     * 使用写dummy这种不易出错的方式
     */
    class Solution02 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode quick = head;
            int i = 0;
            while (i < n && quick.next != null) {
                quick = quick.next;
                i++;
            }
            if (i < n) {
                return head.next;
            }
            ListNode cur = head;
            while (quick.next != null) {
                cur = cur.next;
                quick = quick.next;
            }
            assert cur.next != null;
            cur.next = cur.next.next;
            return head;
        }
    }

    /**
     * 只需遍历一遍，一开始我写的时候是遍历两遍，注意两点：
     * 1）快节点和慢节点之间间隔
     * 2）第一个节点为要删除的节点的前一个节点）索引的关系，
     * 3）删除的节点是否是第一个节点
     */
    class Solution01 {
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

