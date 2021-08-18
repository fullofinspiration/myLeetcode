package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;

public class _0160_IntersectionOfTwoLinkedList {
    public class Solution {
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