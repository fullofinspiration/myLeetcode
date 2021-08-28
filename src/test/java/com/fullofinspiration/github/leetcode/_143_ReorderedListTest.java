package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class _143_ReorderedListTest {
    private static final _143_ReorderedList.Solution SOLUTION = new _143_ReorderedList().new Solution();

    @Test
    public void test00() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4});
        SOLUTION.reorderList(listNode);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 4, 2, 3});
        Assert.assertTrue( ListNodeUtil.equal(expect, listNode));
    }

    @Test
    public void test01() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        SOLUTION.reorderList(listNode);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 5, 2, 4, 3});
        Assert.assertTrue( ListNodeUtil.equal(expect, listNode));
    }


}