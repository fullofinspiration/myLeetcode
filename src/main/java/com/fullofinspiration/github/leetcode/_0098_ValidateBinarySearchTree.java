package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _0098_ValidateBinarySearchTree {
    /**
     * https://leetcode.cn/problems/validate-binary-search-tree/solutions/230256/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution
     * 21:19-21:28 10min
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValid(TreeNode root, long low, long high) {
            if (root == null) {
                return true;
            }
            int val = root.val;
            if (val <= low || val >= high) {
                return false;
            }
            return isValid(root.left, low, val) && isValid(root.right, val, high);
        }
    }

    class Solution00 {
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
