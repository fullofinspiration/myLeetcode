package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class _0113_PathSum2Test {
    @Test
    public void test00() {
        _0113_PathSum2.Solution solution = new _0113_PathSum2().new Solution();
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode4_1 = new TreeNode(4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4_2 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode5_2 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode5.left = treeNode4_1;
        treeNode5.right = treeNode8;
        treeNode4_1.left = treeNode11;
        treeNode11.left = treeNode7;
        treeNode11.right = treeNode2;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode4_2;
        treeNode4_2.left = treeNode5_2;
        treeNode4_2.right = treeNode1;
        List<List<Integer>> lists = solution.pathSum(treeNode5, 22);
        List<List<Integer>> expect = ImmutableList.of(
                ImmutableList.of(5, 4, 11, 2),
                ImmutableList.of(5, 8, 4, 5));
        boolean equal = ListUtil.equal(expect, lists);
        assertTrue(equal);
    }

    @Test
    public void test01() {
        _0113_PathSum2.Solution solution = new _0113_PathSum2().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        List<List<Integer>> lists = solution.pathSum(treeNode1, 0);
        assertTrue(lists.isEmpty());
    }

    @Test
    public void test02() {
        _0113_PathSum2.Solution solution = new _0113_PathSum2().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        List<List<Integer>> lists = solution.pathSum(treeNode1, 0);
        assertTrue(lists.isEmpty());
    }

    @Test
    public void test03() {
        _0113_PathSum2.Solution solution = new _0113_PathSum2().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        List<List<Integer>> lists = solution.pathSum(treeNode1, 3);
        List<List<Integer>> expect = ImmutableList.of(
                ImmutableList.of(1, 2));
        boolean equal = ListUtil.equal(expect, lists);
        assertTrue(equal);
    }
}