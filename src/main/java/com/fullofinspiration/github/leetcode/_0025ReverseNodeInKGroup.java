package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

/**
 * 第二道hard题，调试了好久，现场肯定做不出来
 */
public class _0025ReverseNodeInKGroup {
    class Solution {
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
