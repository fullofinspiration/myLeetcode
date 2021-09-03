package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _0098_ValidateBinarySearchTreeTest {
    private static final _0098_ValidateBinarySearchTree.Solution SOLUTION = new _0098_ValidateBinarySearchTree().new Solution();

    @Test
    public void test00() {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        boolean validBST = SOLUTION.isValidBST(treeNode2);
        assertTrue(validBST);
    }

    @Test
    public void test02() {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode5.left = treeNode1;
        treeNode5.right = treeNode4;
        treeNode4.left = treeNode3;
        treeNode4.right = treeNode6;
        boolean validBST = SOLUTION.isValidBST(treeNode5);
        assertFalse(validBST);
    }

    @Test
    public void test03() {
        TreeNode treeNode2_1 = new TreeNode(2);
        TreeNode treeNode2_2 = new TreeNode(2);
        TreeNode treeNode2_3 = new TreeNode(2);
        treeNode2_1.left = treeNode2_2;
        treeNode2_1.right = treeNode2_3;
        boolean validBST = SOLUTION.isValidBST(treeNode2_1);
        assertFalse(validBST);
    }

    @Test
    public void test04() {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode6;
        treeNode6.left = treeNode3;
        treeNode6.right = treeNode7;
        boolean validBST = SOLUTION.isValidBST(treeNode5);
        assertFalse(validBST);
    }

}