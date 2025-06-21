package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0160_IntersectionOfTwoLinkedList {
    /**
     * https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/12624/intersection-of-two-linked-lists-shuang-zhi-zhen-l/?envType=study-plan-v2&envId=top-100-liked
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA, b = headB;
            while (a != b) {
                a = a != null ? a.next : headB;
                b = b != null ? b.next : headA;
            }
            return a;
        }
    }

    public class Solution01 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA, curB = headB;
            while (curA != null && curB != null) {
                curA = curA.next;
                curB = curB.next;
            }
            int extra = 0;
            if (curA != null) {
                while (curA != null) {
                    extra++;
                    curA = curA.next;
                }
                while (extra-- > 0) {
                    headA = headA.next;
                }
            } else {
                while (curB != null) {
                    extra++;
                    curB = curB.next;
                }
                while (extra-- > 0) {
                    headB = headB.next;
                }
            }

            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }
            return headA;
        }
    }

    public class Solution00 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode first = headA;
            ListNode second = headB;
            while (first != null && second != null) {
                first = first.next;
                second = second.next;
            }
            ListNode graterBegin;
            ListNode shorterBegin;
            ListNode graterMid;
            if (first != null) {
                graterBegin = headA;
                graterMid = first;
                shorterBegin = headB;

            } else {
                shorterBegin = headA;
                graterMid = second;
                graterBegin = headB;
            }
            while (graterMid != null) {
                graterBegin = graterBegin.next;
                graterMid = graterMid.next;
            }
            while (shorterBegin != null && shorterBegin != graterBegin) {
                shorterBegin = shorterBegin.next;
                graterBegin = graterBegin.next;
            }
            return shorterBegin;
        }
    }
}