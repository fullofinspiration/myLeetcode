package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import org.junit.Test;

public class _0021_MergeTwoSortedListTests {
    private static final _0021_MergeTwoSortedList.Solution SOLUTION = new _0021_MergeTwoSortedList().new Solution();

    @Test
    public void test00() {
        ListNode firstList = ListNodeUtil.buildListNode(new int[]{1, 2, 4});
        ListNode secondList = ListNodeUtil.buildListNode(new int[]{1, 3, 4});
        ListNode result = SOLUTION.mergeTwoLists(firstList, secondList);
        ListNode excepted = ListNodeUtil.buildListNode(new int[]{1, 1, 2, 3, 4, 4});
        assertIsEqual(excepted, result);
    }

    @Test
    public void test01() {
        ListNode result = SOLUTION.mergeTwoLists(ListNodeUtil.buildListNode(new int[]{}), ListNodeUtil.buildListNode(new int[]{}));
        ListNode excepted = ListNodeUtil.buildListNode(new int[]{});
        assertIsEqual(result, excepted);
    }

    @Test
    public void test02() {
        ListNode result = SOLUTION.mergeTwoLists(ListNodeUtil.buildListNode(new int[]{}), ListNodeUtil.buildListNode(new int[]{0}));
        ListNode excepted = ListNodeUtil.buildListNode(new int[]{0});
        assertIsEqual(result, excepted);
    }

    private void assertIsEqual(ListNode first, ListNode second) {
        if (first == null && second == null) {
            return;
        }
        if (first == null || second == null) {
            String msg = String.format("One is null but another not null! first: %s, second: %s", first, second);
            throw new IllegalStateException(msg);
        }
        if (first.getVal() != second.getVal()) {
            String msg = String.format("First value: %s is not equal to second value: %s", first.val, second.val);
            throw new IllegalStateException(msg);
        }
        assertIsEqual(first.getNext(), second.getNext());
    }

}