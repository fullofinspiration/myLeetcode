package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

public class _0108ConvertArrayToBST {
    /**
     * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/solutions/312607/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33
     * 21:33-21:40 共7min
     */
    class Solution {
        private int[] nums;

        public TreeNode sortedArrayToBST(int[] nums) {
            this.nums = nums;
            return helper(0, nums.length - 1);
        }

        private TreeNode helper(int low, int high) {
            if (low > high) {
                return null;
            }
            int rootIdx = (low + high + 1) / 2;
            TreeNode treeNode = new TreeNode(nums[rootIdx]);
            treeNode.left = helper(low, rootIdx - 1);
            treeNode.right = helper(rootIdx + 1, high);
            return treeNode;
        }
    }
}
