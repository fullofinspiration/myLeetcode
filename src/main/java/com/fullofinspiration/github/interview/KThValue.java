package com.fullofinspiration.github.interview;

import com.fullofinspiration.github.tool.ListNode;

/**
 * 滴滴：单项链表倒数第k个节点
 */
public class KThValue {
    public static void main(String[] args) {
        KThValue kThValue = new KThValue();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        int val = kThValue.kthValue(node1, 1);
        System.out.println("expect: 3, actually: " + val);


    }

    /**
     * @param head
     * @param kth  从1开始
     */
    private int kthValue(ListNode head, int kth) {
        if (head == null) {
            return -1;
        }
        if (kth <= 0) {
            throw new IllegalArgumentException();
        }
        ListNode slow = head, quick = head;
        while (kth-- > 0 && quick != null) {
            quick = quick.next;
        }
        if (kth > 0) {
            throw new IllegalArgumentException();
        }
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow.val;
    }

}
