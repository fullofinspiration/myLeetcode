package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

/**
 * Created by Zhenpeng Zhang on 2021/1/21.
 */
public class _0203_LinkedListRemove {

    public static void main(String[] args) {
        _0203_LinkedListRemove linkedListRemove = new _0203_LinkedListRemove();
        Solution solution = linkedListRemove.new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode result1 = solution.removeElements(listNode1, listNode3.val);
        while (result1 != null) {
            System.out.println(result1.val);
            result1 = result1.next;
        }


    }

    /**
     * 我写的这种方式已经很简单了，有种加上一个空的头节点，更加简单，但是可能想不到
     */
    class Solution {

        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode result = null;
            ListNode pre = head;

            while (head != null) {
                if (head.val == val) {
                    pre.next = head.next;
                } else {
                    pre = head;
                }
                if (result == null && head.val != val) {
                    result = head;
                }
                head = head.next;
            }
            return result;
        }
    }
}
