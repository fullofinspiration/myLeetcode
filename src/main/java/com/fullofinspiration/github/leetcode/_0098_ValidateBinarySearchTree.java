package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _0098_ValidateBinarySearchTree {
    class Solution {
        Integer pre;
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return validBST(root);
        }

        boolean validBST(TreeNode node) {
            if (node.left != null) {
                boolean validBST = validBST(node.left);
                if (!validBST) {
                    return false;
                }
            }
            if (pre != null && pre >= node.val) {
                return false;
            }
            pre = node.val;
            if (node.right != null) {
                return validBST(node.right);
            }
            return true;
        }
    }
}
