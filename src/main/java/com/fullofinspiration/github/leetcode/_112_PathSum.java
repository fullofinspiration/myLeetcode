package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _112_PathSum {
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            return hasPathSum(root, 0, targetSum);
        }

        private boolean hasPathSum(TreeNode curNode, int curSum, int targetSum) {
            if (curNode == null) {
                return false;
            }
            curSum += curNode.val;
            if (curNode.left == null && curNode.right == null && curSum == targetSum) {
                return true;
            }
            return hasPathSum(curNode.left, curSum, targetSum) || hasPathSum(curNode.right, curSum, targetSum);
        }
    }
}
