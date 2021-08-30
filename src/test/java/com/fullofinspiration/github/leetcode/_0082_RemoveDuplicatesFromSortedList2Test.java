package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class _0082_RemoveDuplicatesFromSortedList2Test {
    private static final _0082_RemoveDuplicatesFromSortedList2.Solution SOLUTION = new _0082_RemoveDuplicatesFromSortedList2().new Solution();

    @Test
    public void test00() {
        int[] ints = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = ListNodeUtil.buildListNode(ints);
        ListNode rst = SOLUTION.deleteDuplicates(head);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 2, 5});
        assertTrue(ListNodeUtil.equal(expect, rst));
    }

    @Test
    public void test01() {
        int[] ints = {1, 1, 1, 2, 3};
        ListNode head = ListNodeUtil.buildListNode(ints);
        ListNode rst = SOLUTION.deleteDuplicates(head);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{2, 3});
        assertTrue(ListNodeUtil.equal(expect, rst));
    }

    @Test
    public void test02() {
        int[] ints = {-1, 0, 0, 0, 0, 3, 3};
        ListNode head = ListNodeUtil.buildListNode(ints);
        ListNode rst = SOLUTION.deleteDuplicates(head);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{-1});
        assertTrue(ListNodeUtil.equal(expect, rst));
    }
}