package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class _0148SortListTest {
    private static final _0148SortList.Solution SOLUTION = new _0148SortList().new Solution();

    @Test
    public void test00() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{4, 2, 1, 3});
        ListNode res = SOLUTION.sortList(listNode);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4});
        boolean equal = ListNodeUtil.equal(expect, res);
        assertTrue(equal);
    }

    @Test
    public void test01() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{-1, 5, 3, 4, 0});
        ListNode res = SOLUTION.sortList(listNode);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{-1, 0, 3, 4, 5});
        boolean equal = ListNodeUtil.equal(expect, res);
        assertTrue(equal);
    }

    @Test
    public void test02() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{});
        ListNode res = SOLUTION.sortList(listNode);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{});
        boolean equal = ListNodeUtil.equal(expect, res);
        assertTrue(equal);
    }

    @Test
    public void test03() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{-1, 5, 3});
        ListNode res = SOLUTION.sortList(listNode);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{-1, 3, 5});
        boolean equal = ListNodeUtil.equal(expect, res);
        assertTrue(equal);
    }
}