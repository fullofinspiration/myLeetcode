package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.fullofinspiration.github.util.TreeNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0114_FlattenBinaryToLinkedListTest {
    @Test
    public void test00() {
        _0114_FlattenBinaryToLinkedList.Solution solution = new _0114_FlattenBinaryToLinkedList().new Solution();
        TreeNode input = buildTree00();
        solution.flatten(input);
        TreeNode expect = buildExpect00();
        boolean equal = TreeNodeUtil.equal(expect, input);
        Assert.assertTrue(equal);
    }

    private TreeNode buildExpect00() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        node5.right = node6;
        return node1;
    }

    private TreeNode buildTree00() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        return node1;
    }

}