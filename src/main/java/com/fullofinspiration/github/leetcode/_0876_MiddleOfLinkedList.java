package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0876_MiddleOfLinkedList {
    /**
     * https://leetcode.com/problems/middle-of-the-linked-list/solutions/154763/remember-this-pattern-for-problems-that-require-middle-finding-in-a-linked-list/?orderBy=most_votes
     * 终止条件：当前节点不为null 同时当前节点下一个节点不为null
     * 返回slow指针指向的值
     * 对比solution01 :1 代码简洁，优雅 2 不需要新建dummy节点，3不需要判断cur.next是否为null
     */
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, quick = head;
            while (quick != null && quick.next != null) {
                slow = slow.next;
                quick = quick.next.next;
            }
            return slow;
        }
    }

    class Solution01 {
        /**
         * 为了保证单数双数节点终止条件均为quick == null,增加一个dummy节点（实际测试5个节点和6个节点慢节点均能成功指向中间节点）
         * 出错地点：新建dummy=head，应改为：dummy=new ListNode() dummy.next=head;
         */
        public ListNode middleNode(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode slow = dummy, quick = dummy;
            while (quick != null) {
                slow = slow.next;
                quick = quick.next;
                if (quick != null) {
                    quick = quick.next;
                }
            }
            return slow;
        }
    }
}
