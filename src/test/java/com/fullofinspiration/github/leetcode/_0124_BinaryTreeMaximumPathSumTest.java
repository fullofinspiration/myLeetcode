package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0124_BinaryTreeMaximumPathSumTest extends TestCase {
    @Test
    public void test00() {
        _0124_BinaryTreeMaximumPathSum.Solution solution = new _0124_BinaryTreeMaximumPathSum().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        int actual = solution.maxPathSum(node1);
        Assert.assertEquals(6, actual);
    }

    @Test
    public void test01() {
        _0124_BinaryTreeMaximumPathSum.Solution solution = new _0124_BinaryTreeMaximumPathSum().new Solution();
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        int actual = solution.maxPathSum(node1);
        Assert.assertEquals(42, actual);
    }
    @Test
    public void test02() {
        _0124_BinaryTreeMaximumPathSum.Solution solution = new _0124_BinaryTreeMaximumPathSum().new Solution();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(-1);
        node1.left = node2;
        int actual = solution.maxPathSum(node1);
        Assert.assertEquals(2, actual);
    }
}