package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.fullofinspiration.github.util.TreeNodeUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class _0226_InvertBinaryTreeTest {
    private static final _0226_InvertBinaryTree.Solution SOLUTION = new _0226_InvertBinaryTree().new Solution();

    @Test
    public void test00() {
        TreeNode treeNode4 = buildNode();
        TreeNode rst = SOLUTION.invertTree(treeNode4);
        TreeNode expect = buildNode1();
        boolean equal = TreeNodeUtil.equal(expect, rst);
        assertTrue(equal);
    }


    @Test
    public void test01() {
        TreeNode treeNode4 = buildNode2();
        TreeNode rst = SOLUTION.invertTree(treeNode4);
        TreeNode expect = buildNode3();
        boolean equal = TreeNodeUtil.equal(expect, rst);
        assertTrue(equal);
    }


    private TreeNode buildNode() {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        treeNode7.left = treeNode6;
        treeNode7.right = treeNode9;
        return treeNode4;
    }

    private TreeNode buildNode1() {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(1);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        treeNode7.left = treeNode6;
        treeNode7.right = treeNode9;
        return treeNode4;
    }


    private TreeNode buildNode2() {
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(3);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;
        return treeNode4;
    }

    private TreeNode buildNode3() {
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode7 = new TreeNode(1);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;
        return treeNode4;
    }
}