package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _0110_BalancedBinaryTree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getDepth(root) != -1;
        }
        private int getDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftDepth = getDepth(node.left);
            if (leftDepth == -1) {
                return -1;
            }
            int rightDepth = getDepth(node.right);
            if (rightDepth == -1) {
                return -1;
            }
            if (Math.abs(leftDepth - rightDepth) > 1) {
                return -1;
            }
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
