package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0141_CircleList {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, quick = head;
            while (true) {
                if (quick == null || quick.next == null) {
                    return false;
                }
                slow = slow.next;
                quick = quick.next.next;
                if (slow == quick) {
                    return true;
                }
            }
        }
    }

    /**
     * https://leetcode.com/problems/linked-list-cycle/solutions/44694/accepted-clean-java-solution/?orderBy=most_votes
     */
    public class Solution01 {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode first = head, second = head;
            second = head.next;
            while (first != null && second != null) {
                if (first == second) {
                    return true;
                }
                first = first.next;
                second = second.next;
                second = second == null ? null : second.next;
            }
            return false;
        }
    }

    class Solution00 {
        public boolean hasCyCle(ListNode head) {
            Set<ListNode> visitedNodes = new HashSet<>();
            while (head != null) {
                if (visitedNodes.contains(head)) {
                    return true;
                }
                visitedNodes.add(head);
                head = head.getNext();
            }
            return false;
        }
    }
}
