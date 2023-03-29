package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0023_MergeKListsTest extends TestCase {
    @Test
    public void test00() {
        _0023_MergeKLists.Solution solution = new _0023_MergeKLists().new Solution();
        ListNode[]input =new ListNode[]{ListNodeUtil.buildListNode(new int[]{1,4,5}),
                ListNodeUtil.buildListNode(new int[]{1,3,4}),
                        ListNodeUtil.buildListNode(new int[]{2,6})};
        ListNode expect = ListNodeUtil.buildListNode(new int[]{1,1,2,3,4,4,5,6});
        ListNode actual = solution.mergeKLists(input);
        boolean equal = ListNodeUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0023_MergeKLists.Solution solution = new _0023_MergeKLists().new Solution();
        ListNode[]input =new ListNode[]{ListNodeUtil.buildListNode(new int[]{}),
        };
        ListNode expect = ListNodeUtil.buildListNode(new int[]{});
        ListNode actual = solution.mergeKLists(input);
        boolean equal = ListNodeUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0023_MergeKLists.Solution solution = new _0023_MergeKLists().new Solution();
        ListNode[]input = null;
        ListNode expect = ListNodeUtil.buildListNode(new int[]{});
        ListNode actual = solution.mergeKLists(input);
        boolean equal = ListNodeUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

}