package com.fullofinspiration.github.leetcode;


import com.fullofinspiration.github.tool.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class _0206_ReverseLinkedListTest {
    private static final _0206_ReverseLinkedList.Solution SOLUTION = newSolution();

    @Test
    public void test1() {
        ListNode listNode = SOLUTION.reverseList(buildFirst());
        assertEquals(2, listNode.val);
        listNode = listNode.next;
        assertEquals(1, listNode.val);
        assertNull(listNode.next);

    }

    @Test
    public void test2() {
        ListNode listNode = SOLUTION.reverseList(buildSeocndExample());
        int i = 5;
        while (i != 0) {
            assertEquals(i, listNode.val);
            listNode = listNode.next;
            i--;
        }
        assertNull(listNode);
    }

    private static _0206_ReverseLinkedList.Solution newSolution() {
        _0206_ReverseLinkedList list = new _0206_ReverseLinkedList();
        return list.new Solution();
    }

    /**
     * 1, 2
     */
    private static ListNode buildFirst() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;
        return first;
    }

    private static ListNode buildSeocndExample() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode1;
    }


}