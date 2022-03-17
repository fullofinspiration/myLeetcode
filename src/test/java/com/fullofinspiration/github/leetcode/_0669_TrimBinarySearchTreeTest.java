package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.leetcode._0669_TrimBinarySearchTree.Solution;
import com.fullofinspiration.github.tool.TreeNode;
import com.fullofinspiration.github.util.TreeNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/28 2:49 PM
 */
public class _0669_TrimBinarySearchTreeTest extends TestCase {

  private static final Solution SOLUTION = new _0669_TrimBinarySearchTree().new Solution();

  @Test
  public void test00() {
    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    treeNode1.left = treeNode0;
    treeNode1.right = treeNode2;
    TreeNode rst = SOLUTION.trimBST(treeNode1, 1, 2);

    boolean equal = TreeNodeUtil.equal(treeNode1, rst);
    Assert.assertTrue(equal);
  }

  @Test
  public void test01() {
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode0 = new TreeNode(0);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode1 = new TreeNode(1);
    treeNode3.left = treeNode0;
    treeNode3.right = treeNode4;
    treeNode0.right = treeNode2;
    treeNode2.left = treeNode1;

    TreeNode rst = SOLUTION.trimBST(treeNode3, 1, 3);

    TreeNode treeNodeRst_3 = new TreeNode(3);
    TreeNode treeNodeRst_2 = new TreeNode(2);
    TreeNode treeNodeRst_1 = new TreeNode(1);
    treeNodeRst_3.left = treeNodeRst_2;
    treeNodeRst_2.left = treeNodeRst_1;

    boolean equal = TreeNodeUtil.equal(rst, treeNodeRst_3);

    Assert.assertTrue(equal);
  }
}