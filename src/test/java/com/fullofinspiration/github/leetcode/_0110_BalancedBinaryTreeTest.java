package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _0110_BalancedBinaryTreeTest {
    private static final _0110_BalancedBinaryTree.Solution SOLUTION = new _0110_BalancedBinaryTree().new Solution();

    @Test
    public void test00() {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        boolean balanced = SOLUTION.isBalanced(treeNode3);
        Assert.assertTrue(balanced);

    }

    @Test
    public void test01() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2_1 = new TreeNode(2);
        TreeNode treeNode2_2 = new TreeNode(2);
        TreeNode treeNode3_1 = new TreeNode(3);
        TreeNode treeNode3_2 = new TreeNode(3);
        TreeNode treeNode4_1 = new TreeNode(4);
        TreeNode treeNode4_2 = new TreeNode(4);
        treeNode1.left = treeNode2_1;
        treeNode1.right = treeNode2_2;
        treeNode2_1.left = treeNode3_1;
        treeNode2_1.right = treeNode3_2;
        treeNode3_1.left = treeNode4_1;
        treeNode3_1.right = treeNode4_2;

        boolean balanced = SOLUTION.isBalanced(treeNode1);
        assertFalse(balanced);
    }

    @Test
    public void test02() {
        boolean balanced = SOLUTION.isBalanced(null);
        assertTrue(balanced);
    }

}