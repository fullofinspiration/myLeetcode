package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _0543_DiameterOfBinaryTreeTest extends TestCase {
    @Test
    public void test00() {
        _0543_DiameterOfBinaryTree.Solution solution = new _0543_DiameterOfBinaryTree().new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        int actual = solution.diameterOfBinaryTree(node1);
        Assert.assertEquals(3, actual);
    }

    @Test
    public void test01() {
        _0543_DiameterOfBinaryTree.Solution solution = new _0543_DiameterOfBinaryTree().new Solution();
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        int actual = solution.diameterOfBinaryTree(node1);
        Assert.assertEquals(1, actual);
    }

}