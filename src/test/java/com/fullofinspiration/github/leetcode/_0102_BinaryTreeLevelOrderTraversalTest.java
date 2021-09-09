package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class _0102_BinaryTreeLevelOrderTraversalTest {
    private static final _0102_BinaryTreeLevelOrderTraversal.Solution SOLUTION = new _0102_BinaryTreeLevelOrderTraversal().new Solution();

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
        List<List<Integer>> rst = SOLUTION.levelOrder(treeNode3);
        List<List<Integer>> expect = ImmutableList.of(ImmutableList.of(3),
                ImmutableList.of(9, 20), ImmutableList.of(15, 7));

        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test01() {
        TreeNode treeNode1 = new TreeNode(1);

        List<List<Integer>> rst = SOLUTION.levelOrder(treeNode1);
        List<List<Integer>> expect = ImmutableList.of(ImmutableList.of(1));

        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

    @Test
    public void test02() {
        List<List<Integer>> rst = SOLUTION.levelOrder(null);
        List<List<Integer>> expect = Collections.emptyList();

        boolean equal = ListUtil.equal(expect, rst);
        Assert.assertTrue(equal);
    }

}