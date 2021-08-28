package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

/**
 * if (node == null) {
 * return 0;
 * }
 * return 1+Math.max(node.left, node.right);
 */
public class _104_MaxiMumDepthOfBinaryTree {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        }
    }
}
