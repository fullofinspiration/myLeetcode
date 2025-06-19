package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeKthFinder {
    /**
     * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/1050055/er-cha-sou-suo-shu-zhong-di-kxiao-de-yua-8o07
     * 其实是迭代方式的中序遍历
     * 21:03-21:17 边看答案边写
     */
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> all = new ArrayDeque<>();
            while (root != null || !all.isEmpty()) {
                while (root != null) {
                    all.push(root);
                    root = root.left;
                }
                root = all.pop();
                if (--k == 0) {
                    return root.val;
                }
                root= root.right;
            }
            throw new IllegalStateException();
        }
    }
}
