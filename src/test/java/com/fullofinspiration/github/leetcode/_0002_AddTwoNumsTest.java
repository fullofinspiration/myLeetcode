package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class _0002_AddTwoNumsTest {
    private static final _0002_AddTwoNums.Solution SOLUTION = new _0002_AddTwoNums().new Solution();

    @Test
    public void test00() {
        ListNode l1 = ListNodeUtil.buildListNode(new int[]{2, 4, 3});
        ListNode l2 = ListNodeUtil.buildListNode(new int[]{5, 6, 4});
        ListNode res = SOLUTION.addTwoNumbers(l1, l2);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{7, 0, 8});
        Assert.assertTrue(ListNodeUtil.equal(expect, res));
    }

    @Test
    public void test01() {
        ListNode l1 = ListNodeUtil.buildListNode(new int[]{0});
        ListNode l2 = ListNodeUtil.buildListNode(new int[]{0});
        ListNode res = SOLUTION.addTwoNumbers(l1, l2);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{0});
        Assert.assertTrue(ListNodeUtil.equal(expect, res));
    }

    @Test
    public void test02() {
        ListNode l1 = ListNodeUtil.buildListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNodeUtil.buildListNode(new int[]{9, 9, 9, 9});
        ListNode res = SOLUTION.addTwoNumbers(l1, l2);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        Assert.assertTrue(ListNodeUtil.equal(expect, res));
    }
}