package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.fullofinspiration.github.util.TreeNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0106_ConstructBinaryTreeFromInOrderAndPostOrderTraversalTest extends TestCase {

    @Test
    public void test00() {
        _0106_ConstructBinaryTreeFromInOrderAndPostOrderTraversal.Solution solution = new _0106_ConstructBinaryTreeFromInOrderAndPostOrderTraversal().new Solution();
        TreeNode rst = solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        boolean equal = TreeNodeUtil.equal(node3, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        _0106_ConstructBinaryTreeFromInOrderAndPostOrderTraversal.Solution solution = new _0106_ConstructBinaryTreeFromInOrderAndPostOrderTraversal().new Solution();
        TreeNode rst = solution.buildTree(new int[]{-1}, new int[]{-1});
        TreeNode node3 = new TreeNode(-1);
        boolean equal = TreeNodeUtil.equal(node3, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        _0106_ConstructBinaryTreeFromInOrderAndPostOrderTraversal.Solution solution = new _0106_ConstructBinaryTreeFromInOrderAndPostOrderTraversal().new Solution();
        TreeNode rst = solution.buildTree(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3});
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        boolean equal = TreeNodeUtil.equal(node3, rst);
        Assert.assertTrue(equal);
    }
}