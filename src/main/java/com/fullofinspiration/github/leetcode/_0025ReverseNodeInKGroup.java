package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 第二道hard题，调试了好久，现场肯定做不出来
 */
public class _0025ReverseNodeInKGroup {

    /**
     * 1 注意将尾节点下一个节点设置成null
     * 2 顺序逆序的判断
     * 3 
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int batch) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode();
            ListNode curTail = dummyHead;
            while (head != null) {
                ListNode headIfAsc = head;
                Map<ListNode, ListNode> node2Pre = new HashMap<>();
                ListNode pre = null;
                int curSize = 0;
                while (head != null && curSize < batch) {
                    curSize++;
                    node2Pre.put(head, pre);
                    pre = head;
                    head = head.next;
                }
                if (curSize < batch) {
                    while (headIfAsc != null) {
                        curTail.next = headIfAsc;
                        headIfAsc = headIfAsc.next;
                        curTail = curTail.next;
                    }
                    curTail.next = null;
                    return dummyHead.next;

                }
                ListNode curNode = pre;
                System.out.printf("Cur Node: %s%n", curNode);
                while (curNode != null) {
                    System.out.printf("Cur tail: %s%n", curTail);
                    curTail.next = curNode;
                    curTail = curNode;
                    curNode = node2Pre.get(curNode);
                }
            }
            curTail.next = null;
            return dummyHead.next;
        }
    }
    class Solution1 {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode fakeHead = new ListNode();
            fakeHead.next = head;

            ListNode curHead = fakeHead;
            while (true) {
                int curLoopSize = k;
                ListNode preNextNode = curHead;
                ListNode lastNodeAfterLoop = curHead.next;
                while (curLoopSize > 0 && preNextNode.next != null) {
                    preNextNode = preNextNode.next;
                    curLoopSize--;
                }
                if (curLoopSize > 0) {
                    return fakeHead.next;
                }
                ListNode curNode = curHead.next;
                curHead.next = preNextNode.next;
                curLoopSize = k;
                while (--curLoopSize >= 0) {
                    ListNode tmp = curNode.next;
                    curNode.next = curHead.next;
                    curHead.next = curNode;
                    curNode = tmp;
                }
                curHead = lastNodeAfterLoop;
            }
        }
    }
}
