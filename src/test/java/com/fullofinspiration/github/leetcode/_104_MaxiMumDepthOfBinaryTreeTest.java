package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class _104_MaxiMumDepthOfBinaryTreeTest {
    private static final _104_MaxiMumDepthOfBinaryTree.Solution SOLUTION = new _104_MaxiMumDepthOfBinaryTree().new Solution();

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
        int i = SOLUTION.maxDepth(treeNode3);
        Assert.assertEquals(3, i);
    }

}