package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _0543_DiameterOfBinaryTree {
    class Solution {
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            doGetDiameter(root);
            return max;
        }

        private int doGetDiameter(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = doGetDiameter(root.left);
            int right = doGetDiameter(root.right);
            max = Math.max(max, left + right);
            return Math.max(left, right) + 1;
        }
    }

    /**
     * https://leetcode.com/problems/diameter-of-binary-tree/solutions/101132/java-solution-maxdepth/?orderBy=most_votes
     * 1 遍历所有的节点，得到所有节点左边最大值和右边最大值，则经过该节点的值为leftMax+rightMax
     * 2 如果当前节点最大值比最大值还要大，则更新最大值
     */
    class Solution00 {
        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            getMax(root);
            return max;
        }

        /**
         * 当前节点为非root节点(层级最低的节点)时，经过当前节点的最大深度
         */
        private int getMax(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = getMax(node.left);
            int right = getMax(node.right);
            max = Math.max(max, left + right);
            return 1 + Math.max(left, right);
        }
    }
}
