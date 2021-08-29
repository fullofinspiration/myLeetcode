package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class _0144_BinaryTrePreOrderTraversalTest {
    @Test
    public void test00() {
        _0144_BinaryTrePreOrderTraversal.Solution solution = new _0144_BinaryTrePreOrderTraversal().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        List<Integer> integers = solution.preorderTraversal(treeNode1);
        Assert.assertEquals(ImmutableList.of(1, 2, 3), integers);
    }

    @Test
    public void test01() {
        _0144_BinaryTrePreOrderTraversal.Solution solution = new _0144_BinaryTrePreOrderTraversal().new Solution();
        List<Integer> integers = solution.preorderTraversal(null);
        Assert.assertEquals(Collections.emptyList(), integers);
    }

    @Test
    public void test02() {
        _0144_BinaryTrePreOrderTraversal.Solution solution = new _0144_BinaryTrePreOrderTraversal().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        List<Integer> integers = solution.preorderTraversal(treeNode1);
        Assert.assertEquals(ImmutableList.of(1), integers);
    }

    @Test
    public void test03() {
        _0144_BinaryTrePreOrderTraversal.Solution solution = new _0144_BinaryTrePreOrderTraversal().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        List<Integer> integers = solution.preorderTraversal(treeNode1);
        Assert.assertEquals(ImmutableList.of(1, 2), integers);
    }

    @Test
    public void test04() {
        _0144_BinaryTrePreOrderTraversal.Solution solution = new _0144_BinaryTrePreOrderTraversal().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        List<Integer> integers = solution.preorderTraversal(treeNode1);
        Assert.assertEquals(ImmutableList.of(1, 2), integers);
    }
}