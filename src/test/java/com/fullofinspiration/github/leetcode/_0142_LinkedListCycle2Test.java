package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class _0142_LinkedListCycle2Test {
    private static final _0142_LinkedListCycle2.Solution SOLUTION = new _0142_LinkedListCycle2().new Solution();

    @Test
    public void test00() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{3, 2, 0, -4});
        listNode.next.next.next.next = listNode.next;
        ListNode res = SOLUTION.detectCycle(listNode);
        Assert.assertEquals(listNode.next, res);
    }

    @Test
    public void test01() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2});
        listNode.next.next = listNode;
        ListNode res = SOLUTION.detectCycle(listNode);
        Assert.assertEquals(listNode, res);
    }

    @Test
    public void test02() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1});
        ListNode res = SOLUTION.detectCycle(listNode);
        Assert.assertNull(res);
    }

}