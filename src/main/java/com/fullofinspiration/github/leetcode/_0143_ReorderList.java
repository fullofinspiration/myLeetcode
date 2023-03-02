package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

import java.util.HashMap;
import java.util.Map;

public class _0143_ReorderList {

    /**
     * https://leetcode.com/problems/reorder-list/solutions/44992/java-solution-with-3-steps/comments/232531/
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            ListNode p1 = head, p2 = head;
            while (p1.next != null && p2.next != null && p2.next.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            }
            System.out.printf("succ find mid loc, mid pre value: %s%n", p1.next);

            // reverse
            ListNode preMid = p1;
            ListNode preCurrent = preMid.next;
            preMid.next = null;
            while (preCurrent != null) {
                ListNode tmp = preCurrent.next;
                preCurrent.next = preMid.next;
                preMid.next = preCurrent;
                preCurrent = tmp;
            }
            System.out.println("succ reverse after ");

            p2 = preMid.next;
            p1 = head;
            while (p1 != preMid) {
                preMid.next = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p2.next;
                p2 = preMid.next;
            }
            System.out.println("succ handle result");

        }
    }

    /**
     * https://leetcode.com/problems/reorder-list/solutions/44992/java-solution-with-3-steps/comments/232531
     * 时间复杂度(n) 空间复杂度O(n),但是代码更加简洁
     */
    class Solution01 {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            Map<Integer, ListNode> all = new HashMap<>();
            ListNode cur = head;
            for (int i = 0; cur != null; cur = cur.next, i++) {
                all.put(i, cur);
            }

            for (int i = 0, j = all.size() - 1; ; i++, j--) {
                if (i == j) {
                    all.get(i).next = null;
                    return;
                }
                if (i + 1 == j) {
                    all.get(j).next = null;
                    return;
                }
                all.get(j).next = all.get(i).next;
                all.get(i).next = all.get(j);
            }
        }
    }

    /**
     * 时间复杂度O(n) 空间复杂度O(n)
     */
    class Solution00 {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }

            Map<ListNode, ListNode> node2Pre = new HashMap<>();
            ListNode cur = head;
            while (cur.next != null) {
                node2Pre.put(cur.next, cur);
                cur = cur.next;
            }

            ListNode after = cur;
            ListNode curNode = head;
            int handledSize = 0;
            while (handledSize <= node2Pre.size()) {
                String msg = String.format("preNode val: %s, after val: %s", curNode.val, after.val);
                System.out.println(msg);

                if (curNode == after) {
                    msg = String.format("cur node value is : %s", curNode.val);
                    System.out.println(msg);
                    curNode.next = null;
                    return;
                }
                if (curNode.next == after) {
                    after.next = null;
                    return;
                }
                ListNode tmp = curNode.next;
                curNode.next = after;
                after.next = tmp;
                curNode = tmp;
                after = node2Pre.get(after);
                handledSize += 2;
            }
        }
    }
}

