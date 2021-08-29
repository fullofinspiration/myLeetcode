package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _0129_SumRoot2LeafNumbers {
    class Solution {
        public int sumNumbers(TreeNode root) {
            return sumNumbers(root, 0);
        }

        private int sumNumbers(TreeNode node, int preSum) {
            if (node == null) {
                return 0;
            }
            int curSum = preSum * 10 + node.val;
            if (node.left == null && node.right == null) {
                return curSum;
            }
            return sumNumbers(node.left, curSum) + sumNumbers(node.right, curSum);
        }
    }
}
