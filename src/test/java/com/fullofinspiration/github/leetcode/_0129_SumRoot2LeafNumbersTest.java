package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class _0129_SumRoot2LeafNumbersTest {
    private static final _0129_SumRoot2LeafNumbers.Solution SOLUTION = new _0129_SumRoot2LeafNumbers().new Solution();

    @Test
    public void test00() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        int sum = SOLUTION.sumNumbers(treeNode1);
        Assert.assertEquals(25, sum);
    }

    @Test
    public void test01() {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode4.left = treeNode9;
        treeNode4.right = treeNode0;
        treeNode9.left = treeNode5;
        treeNode9.right = treeNode1;
        int sum = SOLUTION.sumNumbers(treeNode4);
        Assert.assertEquals(1026, sum);
    }

}