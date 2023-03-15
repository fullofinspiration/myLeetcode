package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class _0094_BinaryTreeInorderTraversalTest {
    @Test
    public void test00() {
        _0094_BinaryTreeInorderTraversal.Solution solution = new _0094_BinaryTreeInorderTraversal().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        List<Integer> integers = solution.inorderTraversal(treeNode1);
        Assert.assertEquals(ImmutableList.of(1, 3, 2), integers);
    }

    @Test
    public void test01() {
        _0094_BinaryTreeInorderTraversal.Solution solution = new _0094_BinaryTreeInorderTraversal().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        List<Integer> integers = solution.inorderTraversal(treeNode1);
        Assert.assertEquals(ImmutableList.of(2, 1), integers);
    }

    @Test
    public void test02() {
        _0094_BinaryTreeInorderTraversal.Solution solution = new _0094_BinaryTreeInorderTraversal().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        List<Integer> integers = solution.inorderTraversal(treeNode1);
        Assert.assertEquals(ImmutableList.of(1, 2), integers);
    }

}