package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeKthFinderTest extends TestCase {
    @Test
    public void test00() {
        BinarySearchTreeKthFinder.Solution solution = new BinarySearchTreeKthFinder().new Solution();
        TreeNode input = buildTree00();
        int i = solution.kthSmallest(input, 1);
        Assert.assertEquals(1, i);
    }

    private TreeNode buildTree00() {

        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);

        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        return node3;
    }


}