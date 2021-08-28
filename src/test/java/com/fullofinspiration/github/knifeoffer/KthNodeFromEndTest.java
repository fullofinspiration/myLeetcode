package com.fullofinspiration.github.knifeoffer;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class KthNodeFromEndTest {
    private static final KthNodeFromEnd.Solution SOLUTION = new KthNodeFromEnd().new Solution();

    @Test
    public void test00() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode kthFromEnd = SOLUTION.getKthFromEnd(listNode, 2);
        Assert.assertEquals(4, kthFromEnd.val);
    }

    @Test
    public void test01() {
        ListNode listNode = ListNodeUtil.buildListNode(new int[]{1});
        ListNode kthFromEnd = SOLUTION.getKthFromEnd(listNode, 1);
        Assert.assertEquals(1, kthFromEnd.val);
    }
}