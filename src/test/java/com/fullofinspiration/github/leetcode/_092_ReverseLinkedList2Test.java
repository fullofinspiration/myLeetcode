package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class _092_ReverseLinkedList2Test {
   private static final  _092_ReverseLinkedList2.Solution SOLUTION = new _092_ReverseLinkedList2().new Solution();

    @Test
    public void test00() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = SOLUTION.reverseBetween(listNode, 2, 4);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1, 4, 3, 2, 5});
        Assert.assertTrue(ListNodeUtil.equal(expect,res));
    }

    @Test
    public void test01() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{5});
        ListNode res = SOLUTION.reverseBetween(listNode, 1, 1);
        ListNode expect = ListNodeUtil.buildListNode(new int[]{5});
        Assert.assertTrue(ListNodeUtil.equal(expect,res));
    }

}