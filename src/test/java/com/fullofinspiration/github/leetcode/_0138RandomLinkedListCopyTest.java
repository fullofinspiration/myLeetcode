package com.fullofinspiration.github.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0138RandomLinkedListCopyTest extends TestCase {
    @Test
    public void test00() {
        _0138RandomLinkedListCopy.Solution solution = new _0138RandomLinkedListCopy().new Solution();
        _0138RandomLinkedListCopy.Node input = buildNode();

        _0138RandomLinkedListCopy.Node ret = solution.copyRandomList(input);
        while (input != null && ret != null) {
            Assert.assertEquals(input.val, ret.val);
            Assert.assertTrue(input.random==null|| input.random.val== ret.random.val);
            input = input.next;
            ret = ret.next;
        }

    }

    private _0138RandomLinkedListCopy.Node buildNode() {
        _0138RandomLinkedListCopy.Node node1 = new _0138RandomLinkedListCopy.Node(7);

        _0138RandomLinkedListCopy.Node node2 = new _0138RandomLinkedListCopy.Node(13);
        node2.random = node1;
        _0138RandomLinkedListCopy.Node node3 = new _0138RandomLinkedListCopy.Node(11);
        _0138RandomLinkedListCopy.Node node4 = new _0138RandomLinkedListCopy.Node(10);
        _0138RandomLinkedListCopy.Node node5 = new _0138RandomLinkedListCopy.Node(1);
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }
}
