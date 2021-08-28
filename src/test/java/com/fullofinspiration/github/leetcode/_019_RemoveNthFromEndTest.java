package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class _019_RemoveNthFromEndTest {
    private static final _019_RemoveNthFromEnd.Solution SOLUTION = new _019_RemoveNthFromEnd().new Solution();

    @Test
    public void test00() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = SOLUTION.removeNthFromEnd(listNode, 2);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 5});
        Assert.assertTrue(ListNodeUtil.equal(expect, res));
    }

    @Test
    public void test01() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1});
        ListNode res = SOLUTION.removeNthFromEnd(listNode, 1);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{});
        Assert.assertTrue(ListNodeUtil.equal(expect, res));
    }
    @Test
    public void test02() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1,2});
        ListNode res = SOLUTION.removeNthFromEnd(listNode, 1);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1});
        Assert.assertTrue(ListNodeUtil.equal(expect, res));
    }
}