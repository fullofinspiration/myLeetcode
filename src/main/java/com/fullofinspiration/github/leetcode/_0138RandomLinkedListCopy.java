package com.fullofinspiration.github.leetcode;

public class _0138RandomLinkedListCopy {
    /**
     * https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/2361362/138-fu-zhi-dai-sui-ji-zhi-zhen-de-lian-b-6jeo/?envType=study-plan-v2&envId=top-100-liked
     */
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node cur = head;
            while (cur != null) {
                Node node = new Node(cur.val);
                Node tmp = cur;
                cur = cur.next;
                tmp.next = node;
                node.next = cur;
            }
            cur = head;
            while (cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            cur = head;
            Node head2 = cur.next;

            while (cur != null && cur.next!=null) {
                Node tmp = cur.next;
                cur.next = cur.next.next;
                cur = tmp;
            }
            return head2;
        }
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
