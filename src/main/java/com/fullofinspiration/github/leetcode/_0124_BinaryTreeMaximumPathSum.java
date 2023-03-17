package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _0124_BinaryTreeMaximumPathSum {
    /**
     * 完全参考了0543 这道题的逻辑
     * 错误1 最小值应该是负数，因为节点上值是有可能是负数的
     * 错误2 当有一个节点时，需要返回当前节点值，当所有的节点都小于0时，因为可以不从叶子节点开始，可以从任意节点开始，所以需要判断当前节点和0的关系，如果小于0，则丢弃该值
     * 和标准答案基本是一样的：https://leetcode.com/problems/binary-tree-maximum-path-sum/solutions/39775/accepted-short-solution-in-java/?orderBy=most_votes
     */
    class Solution {
        private int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            getMax(root);
            return max;
        }

        /**
         * 若该节点为非最高层级节点，计算返回值
         */
        private int getMax(TreeNode node) {
            if (node == null) {
                return Integer.MIN_VALUE;
            }
            int left = Math.max(getMax(node.left), 0);
            int right = Math.max(getMax(node.right), 0);
            max = Math.max(max, left + right + node.val);
            return node.val + Math.max(left, right);
        }
    }
}
