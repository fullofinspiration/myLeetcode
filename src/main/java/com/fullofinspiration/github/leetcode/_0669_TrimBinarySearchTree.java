package com.fullofinspiration.github.leetcode;


import com.fullofinspiration.github.tool.TreeNode;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/28 2:19 PM
 */
public class _0669_TrimBinarySearchTree {

  class Solution {

    public TreeNode trimBST(TreeNode root, int low, int high) {
      if (root == null) {
        return null;
      }
      if (root.val > high) {
        return trimBST(root.left, low, high);
      }
      if (root.val < low) {
        return trimBST(root.right, low, high);
      }
      root.left = trimBST(root.left, low, high);
      root.right = trimBST(root.right, low, high);
      return root;
    }
  }
}
