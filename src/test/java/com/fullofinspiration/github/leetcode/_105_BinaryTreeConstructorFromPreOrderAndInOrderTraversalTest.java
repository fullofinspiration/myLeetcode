package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.fullofinspiration.github.util.TreeNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _105_BinaryTreeConstructorFromPreOrderAndInOrderTraversalTest {
    @Test
    public void test00() {
        _105_BinaryTreeConstructorFromPreOrderAndInOrderTraversal.Solution solution = new _105_BinaryTreeConstructorFromPreOrderAndInOrderTraversal().new Solution();
        TreeNode expect = buildTree00();
        int[] input1 = {3, 9, 20, 15, 7};
        int[] input2 = {9, 3, 15, 20, 7};
        TreeNode actual = solution.buildTree(input1, input2);
        boolean equal = TreeNodeUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _105_BinaryTreeConstructorFromPreOrderAndInOrderTraversal.Solution solution = new _105_BinaryTreeConstructorFromPreOrderAndInOrderTraversal().new Solution();
        TreeNode expect = buildTree02();
        int[] input1 = {-1};
        int[] input2 = {-1};
        TreeNode actual = solution.buildTree(input1, input2);
        boolean equal = TreeNodeUtil.equal(expect, actual);
        Assert.assertTrue(equal);
    }


    private TreeNode buildTree00() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        return node3;
    }

    private TreeNode buildTree02() {
        TreeNode node = new TreeNode(-1);
        return node;
    }
}