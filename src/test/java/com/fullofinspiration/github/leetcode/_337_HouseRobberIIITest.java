package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class _337_HouseRobberIIITest extends TestCase {
    @Test
    public void test00() {
        _337_HouseRobberIII.Solution solution = new _337_HouseRobberIII().new Solution();
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node3_3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        node3_1.left = node2_1;
        node3_1.right = node3_2;
        node2_1.right = node3_3;
        node3_2.right = node1;
        int rob = solution.rob(node3_1);
        Assert.assertEquals(7, rob);
    }

    @Test
    public void test01() {
        _337_HouseRobberIII.Solution solution = new _337_HouseRobberIII().new Solution();
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        node_1.left = node_2;
        node_2.left = node_4;
        node_1.right = node_3;
        node_3.right = node_5;
        int rob = solution.rob(node_1);
        Assert.assertEquals(10, rob);
    }

    @Test
    public void test02() {
        TreeNode node_3_1 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_1_1 = new TreeNode(1);
        TreeNode node_3_2 = new TreeNode(3);
        TreeNode node_1_2 = new TreeNode(1);

        node_3_1.left = node_4;
        node_3_1.right = node_5;
        node_4.left = node_1_1;
        node_4.right = node_3_2;
        node_5.right = node_1_2;
        _337_HouseRobberIII.Solution solution = new _337_HouseRobberIII().new Solution();
        int rob = solution.rob(node_3_1);
        Assert.assertEquals(9, rob);
    }

    @Test
    public void test03() {
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_3 = new TreeNode(3);
        node_4.left = node_2;
        node_2.left = node_1;
        node_2.right = node_3;
        _337_HouseRobberIII.Solution solution = new _337_HouseRobberIII().new Solution();
        int rob = solution.rob(node_4);
        Assert.assertEquals(8, rob);
    }
}