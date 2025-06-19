package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0437_NodeSumTest {
    @Test
    public void test00() {
        _0437_NodeSum.Solution solution = new _0437_NodeSum().new Solution();
        TreeNode root = buildTree00();
        int i = solution.pathSum(root, 8);
        Assert.assertEquals(3, i);
    }

    @Test
    public void test01() {
        _0437_NodeSum.Solution solution = new _0437_NodeSum().new Solution();
        TreeNode root = buildNode02();
        int i = solution.pathSum(root, -1);
        Assert.assertEquals(1, i);
    }

    private TreeNode buildTree00() {

        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);

        node10.left = node5;
        node10.right = node_3;
        node5.left = node3;
        node5.right = node2;
        node_3.right = node11;
        node3.left = node3_2;
        node3.right = node_2;
        node2.right = node1;
        return node10;
    }

    private TreeNode buildNode02() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node_3 = new TreeNode(-3);
        node1.left = node_2;
        node1.right = node_3;
        return node1;
    }
}