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
            ListNode end = curNode;
            ListNode pre4Begin = head;
            while (pre4Begin.next != null) {
                node2Pre.get(end).next = null;
                end.next = pre4Begin.next;
                pre4Begin.next = end;
                if (end.next != null) {
                    pre4Begin = end;
                }
                if (pre4Begin.next != null) {
                    pre4Begin = pre4Begin.next;
                }
                end = node2Pre.get(end);
            }
        }
    }
}
