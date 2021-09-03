package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _112_PathSumTest {
    private static final _112_PathSum.Solution SOLUTION = new _112_PathSum().new Solution();

    @Test
    public void test00() {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4_2 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_2;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode4.right = treeNode1;
        boolean hasPathSum = SOLUTION.hasPathSum(treeNode5, 22);
        assertTrue(hasPathSum);
    }


    @Test
    public void test01() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        boolean hasPathSum = SOLUTION.hasPathSum(treeNode1, 5);
        assertFalse(hasPathSum);
    }

    @Test
    public void test02() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        boolean hasPathSum = SOLUTION.hasPathSum(treeNode1, 0);
        assertFalse(hasPathSum);
    }
}