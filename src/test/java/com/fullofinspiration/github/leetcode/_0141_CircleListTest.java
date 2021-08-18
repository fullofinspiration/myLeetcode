package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class _0141_CircleListTest {
    private static final _0141_CircleList.Solution SOLUTION = new _0141_CircleList().new Solution();

    @Test
    public void test00() {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(-4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        boolean hasCirCle = SOLUTION.hasCirCle(listNode);
        Assert.assertTrue(hasCirCle);
    }

    @Test
    public void test01() {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode;
        boolean hasCirCle = SOLUTION.hasCirCle(listNode);
        Assert.assertTrue(hasCirCle);
    }

    @Test
    public void test02() {
        ListNode listNode = new ListNode(3);
        boolean hasCirCle = SOLUTION.hasCirCle(listNode);
        Assert.assertFalse(hasCirCle);
    }

}