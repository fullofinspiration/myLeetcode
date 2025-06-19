package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

/**
 * 太难了 跳过
 */
public class _0114_FlattenBinaryToLinkedList {
    /**
     * 开始时间20:10
     * 结束时间20:43
     * 共33min
     * TODO 有空看下里面有多种解法，且通俗易懂
     * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/17274/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26
     */
    class Solution {
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left == null) {
                    root = root.right;
                    continue;
                }
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }
}
