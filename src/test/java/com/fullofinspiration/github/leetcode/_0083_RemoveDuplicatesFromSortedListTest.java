package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class _0083_RemoveDuplicatesFromSortedListTest {
    private static final _0083_RemoveDuplicatesFromSortedList.Solution SOLUTION = new _0083_RemoveDuplicatesFromSortedList().new Solution();

    @Test
    public void test00() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 1, 2});
        ListNode rst = SOLUTION.deleteDuplicates(listNode);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 2});
        boolean equal = ListNodeUtil.equal(expect, rst);
        assertTrue(equal);
    }

    @Test
    public void test01() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 1, 2, 3, 3});
        ListNode rst = SOLUTION.deleteDuplicates(listNode);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 2, 3});
        boolean equal = ListNodeUtil.equal(expect, rst);
        assertTrue(equal);
    }

}