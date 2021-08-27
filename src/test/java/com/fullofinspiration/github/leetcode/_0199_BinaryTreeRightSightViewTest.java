package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class _0199_BinaryTreeRightSightViewTest {
    private static final _0199_BinaryTreeRightSightView.Solution SOLUTION = new _0199_BinaryTreeRightSightView().new Solution();

    @Test
    public void test00() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode4;
        List<Integer> integers = SOLUTION.rightSideView(treeNode1);
        Assert.assertEquals(ImmutableList.of(1, 3, 4), integers);
    }

    @Test
    public void test01() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode3;
        List<Integer> integers = SOLUTION.rightSideView(treeNode1);
        Assert.assertEquals(ImmutableList.of(1, 3), integers);
    }

    @Test
    public void test02() {
        List<Integer> integers = SOLUTION.rightSideView(null);
        Assert.assertEquals(Collections.emptyList(), integers);
    }

}