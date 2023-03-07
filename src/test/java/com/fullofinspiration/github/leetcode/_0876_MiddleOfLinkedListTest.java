package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0876_MiddleOfLinkedListTest extends TestCase {
    @Test
    public void test00() {
        _0876_MiddleOfLinkedList.Solution solution = new _0876_MiddleOfLinkedList().new Solution();
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode rst = solution.middleNode(head);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{3, 4, 5});
        boolean equal = ListNodeUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0876_MiddleOfLinkedList.Solution solution = new _0876_MiddleOfLinkedList().new Solution();
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5, 6});
        ListNode rst = solution.middleNode(head);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{4, 5, 6});
        boolean equal = ListNodeUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }
}