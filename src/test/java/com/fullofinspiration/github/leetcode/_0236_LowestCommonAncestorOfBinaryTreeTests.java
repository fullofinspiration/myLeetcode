package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _0236_LowestCommonAncestorOfBinaryTreeTests {
    private static final _0236_LowestCommonAncestorOfBinaryTree.Solution SOLUTION =
            new _0236_LowestCommonAncestorOfBinaryTree().new Solution();

    @Test
    public void test00() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode root = buildTree00(node5, node4);

        TreeNode treeNode = SOLUTION.lowestCommonAncestor(root, node5, node4);
        assertEquals(5, treeNode.val);
    }

    private TreeNode buildTree00(TreeNode node5, TreeNode node4) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        return node3;
    }

}