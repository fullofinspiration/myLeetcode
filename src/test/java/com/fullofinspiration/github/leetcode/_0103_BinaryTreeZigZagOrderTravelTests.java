package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class _0103_BinaryTreeZigZagOrderTravelTests {
    private static final _0103_BinaryTreeZigZagOrderTravel.Solution SOLUTION = new _0103_BinaryTreeZigZagOrderTravel().new Solution();

    @Test
    public void test00() {
        TreeNode value3 = new TreeNode(3);
        TreeNode value9 = new TreeNode(9);
        TreeNode value20 = new TreeNode(20);
        TreeNode value15 = new TreeNode(15);
        TreeNode value7 = new TreeNode(7);

        value3.left = value9;
        value3.right = value20;
        value20.left = value15;
        value20.right = value7;

        List<List<Integer>> lists = SOLUTION.zigzagLevelOrder(value3);
        assertEquals(3, lists.size());
        assertEquals(ImmutableList.of(3), lists.get(0));
        assertEquals(ImmutableList.of(20, 9), lists.get(1));
        assertEquals(ImmutableList.of(15, 7), lists.get(2));
    }

    @Test
    public void test01() {
        TreeNode root = new TreeNode(1);

        List<List<Integer>> lists = SOLUTION.zigzagLevelOrder(root);

        assertEquals(1, lists.size());
        assertEquals(ImmutableList.of(1), lists.get(0));
    }

    @Test
    public void test02() {
        List<List<Integer>> lists = SOLUTION.zigzagLevelOrder(null);
        assertTrue(lists.isEmpty());
    }

}