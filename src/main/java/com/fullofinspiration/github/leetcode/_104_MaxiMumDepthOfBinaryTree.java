package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _104_MaxiMumDepthOfBinaryTree {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    class Solution02 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        }
    }

    /**
     * 用递归是最方便的：
     * 1 当前节点为1
     * 2 如果当前左节点为null，则左节点最大深度为当前，如果右节点为空，右节点最大深度为当前
     * 3 返回左右中较大的深度
     * 该方式太过复杂，就不调试了，应该利用入参可以不加count这个地方
     */
    class Solution01 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return -1;
            }
            return curMax(root, 1);
        }

        private int curMax(TreeNode cur, int curDepth) {
            if (cur.left == null && cur.right == null) {
                return curDepth;
            }
            if (cur.left == null) {
                return curMax(cur.right, curDepth + 1);
            }
            if (cur.right == null) {
                return curMax(cur.left, curDepth + 1);
            }
            return Math.max(curMax(cur.left, curDepth + 1), curMax(cur.right, curDepth + 1));
        }
    }

    /**
     * if (node == null) {
     * return 0;
     * }
     * return 1+Math.max(node.left, node.right);
     */
    class Solution00 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        }
    }
}
