package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _0101_SymmetricTreeTest {
    private static final _0101_SymmetricTree.Solution SOLUTION = new _0101_SymmetricTree().new Solution();

    @Test
    public void test00() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode2_2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode4_2 = new TreeNode(4);
        TreeNode treeNode3_2 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode2_2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode2_2.left = treeNode4_2;
        treeNode2_2.right = treeNode3_2;

        boolean symmetric = SOLUTION.isSymmetric(treeNode1);
        assertTrue(symmetric);
    }

    @Test
    public void test01() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode2_2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode3_2 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode2_2;
        treeNode2.right = treeNode3;
        treeNode2_2.right = treeNode3_2;

        boolean symmetric = SOLUTION.isSymmetric(treeNode1);
        assertFalse(symmetric);
    }

    @Test
    public void test02() {
        TreeNode treeNode1 = new TreeNode(1);
        boolean symmetric = SOLUTION.isSymmetric(treeNode1);
        assertTrue(symmetric);
    }

}