package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0141_CircleList {
    class Solution {
        public boolean hasCirCle(ListNode head) {
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
