package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class _0160_IntersectionOfTwoLinkedListTests {
    private final _0160_IntersectionOfTwoLinkedList.Solution solution = new _0160_IntersectionOfTwoLinkedList().new Solution();


    @Test
    public void test00() {
        ListNode firstList = ListNodeUtil.buildListNode(new int[]{4, 1, 8, 4, 5});
        ListNode secondList = ListNodeUtil.buildListNode(new int[]{5, 6, 1});
        ListNode secondListHead = secondList;
        secondList.next.next.next = firstList;
        ListNode intersectionNode = solution.getIntersectionNode(secondListHead, firstList);
        Assert.assertEquals(4, intersectionNode.val);
    }

}