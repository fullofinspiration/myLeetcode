package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class _0143_ReorderListTest {
    private static final _0143_ReorderList.Solution SOLUTION = new _0143_ReorderList().new Solution();

    @Test
    public void Test00() {
        ListNode input = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        SOLUTION.reorderList(input);
        ListNode expected = ListNodeUtil.buildListNode(new int[]{1, 5, 2, 4, 3});
        boolean equal = ListNodeUtil.equal(expected, input);
        Assert.assertTrue(equal);
    }

    @Test
    public void Test01() {
        ListNode input = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4});
        SOLUTION.reorderList(input);
        ListNode expected = ListNodeUtil.buildListNode(new int[]{1, 4, 2, 3});
        boolean equal = ListNodeUtil.equal(expected, input);
        Assert.assertTrue(equal);
    }

    @Test
    public void Test02() {
        ListNode input = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4});
        SOLUTION.reorderList(input);
        ListNode expected = ListNodeUtil.buildListNode(new int[]{1, 4, 2, 3});
        boolean equal = ListNodeUtil.equal(expected, input);
        Assert.assertTrue(equal);
    }

}