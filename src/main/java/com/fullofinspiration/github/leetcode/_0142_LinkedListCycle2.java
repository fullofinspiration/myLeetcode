package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 节省空间的算法没有看懂, 后面有空再看https://leetcode.com/problems/linked-list-cycle-ii/discuss/44793/O(n)-solution-by-using-two-pointers-without-change-anything
 */
public class _0142_LinkedListCycle2 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            Set<ListNode> all = new HashSet<>();
            while (head != null) {
                if (all.contains(head)) {
                    return head;
                }
                all.add(head);
                head = head.next;
            }
            return null;
        }
    }
}
