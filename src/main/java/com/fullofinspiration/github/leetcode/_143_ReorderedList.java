package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.HashMap;
import java.util.Map;

public class _143_ReorderedList {
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            if (head.next == null) {
                return;
            }
            Map<ListNode, ListNode> node2Pre = new HashMap<>();
            ListNode curNode = head;
            while (curNode.next != null) {
                node2Pre.put(curNode.next, curNode);
                curNode = curNode.next;
            }

            ListNode last = curNode;
            ListNode preNodeFromStart = head;
            while (preNodeFromStart.next != last && preNodeFromStart != last) {
                ListNode temp = preNodeFromStart.next;
                preNodeFromStart.next = last;
                ListNode temp1 = last.next;
                last.next = temp.next;
                node2Pre.get(last).next = temp;
                temp.next = temp1;

                preNodeFromStart = preNodeFromStart.next;
                last = node2Pre.get(last);
            }
        }
    }
}
