package com.fullofinspiration.github.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zhenpeng Zhang on 2021/2/19.
 */
public class _0148SortList {

    public static void main(String[] args) {
        ListNode listNode = buildList(new Integer[]{3, 2, 4});
        Solution solution = new _0148SortList().new Solution();
        ListNode result = solution.sortList(listNode);
        print(result);
    }

    class Solution {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            int length = 0;
            ListNode tmp = head;
            while (tmp != null) {
                length++;
                tmp = tmp.next;
            }
            for (int i = 0; Math.pow(2, i) < length; i++) {
                int countEach = (int) (Math.pow(2, i));
                head = mergeList(head, countEach);
            }
            return head;
        }

        public ListNode mergeList(ListNode node, int countEach) {
            ListNode cur = new ListNode(-1);
            ListNode result = cur;
            ListNode firstHead = node;
            ListNode secondHead = getNextNthOrNull(node, countEach);
            int abc = 0;
            int def = 0;
            while (firstHead != null && secondHead != null) {
                System.out.println("outer Round: " + abc++);
                int firstHeadCount = 0;
                int secondHeadCount = 0;
                while (firstHead != null && secondHead != null && firstHeadCount < countEach && secondHeadCount < countEach) {
                    System.out.println("inner round: " + def++);
                    if (firstHead.val > secondHead.val) {
                        cur.next = secondHead;
                        cur = secondHead;
                        secondHead = secondHead.next;
                        secondHeadCount++;
                    } else {
                        cur.next = firstHead;
                        cur = firstHead;
                        firstHead = firstHead.next;
                        firstHeadCount++;
                    }
                }
                if (firstHeadCount < countEach) {
                    ListNode curNextValue = cur.next;
                    cur.next = firstHead;
                    cur = getNextNthOrNull(cur, countEach - firstHeadCount);
                    cur.next = curNextValue;
                } else {
                    cur.next = secondHead;
                    cur = getNextNthOrNull(cur, countEach - secondHeadCount);
                }
                firstHead = getNextNthOrNull(cur, 1);
                secondHead = getNextNthOrNull(cur, countEach + 1);
            }
            print(result);
            return result.next;
        }

        private ListNode getNextNthOrNull(ListNode node, int nth) {

            while (node != null && nth-- > 0) {
                node = node.next;
            }
            return node;
        }
    }


    private static ListNode buildList(Integer[] vals) {
        List<ListNode> list = Arrays.stream(vals).map(ListNode::new).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                list.get(i).next = list.get(i + 1);
            }
        }
        print(list.get(0));
        return list.get(0);
    }

    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}