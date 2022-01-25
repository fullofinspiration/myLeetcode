package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class _0025ReverseNodeInKGroupTest {
    private static final _0025ReverseNodeInKGroup.Solution SOLUTION = new _0025ReverseNodeInKGroup().new Solution();

    @Test
    public void test00() {
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode rst = SOLUTION.reverseKGroup(head, 2);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{2, 1, 4, 3, 5});
        boolean equal = ListNodeUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode rst = SOLUTION.reverseKGroup(head, 3);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{3, 2, 1, 4, 5});
        boolean equal = ListNodeUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode rst = SOLUTION.reverseKGroup(head, 1);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        boolean equal = ListNodeUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test03() {
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode rst = SOLUTION.reverseKGroup(head, 1);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        boolean equal = ListNodeUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test04() {
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 2});
        ListNode rst = SOLUTION.reverseKGroup(head, 2);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{2,1});
        boolean equal = ListNodeUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }
}