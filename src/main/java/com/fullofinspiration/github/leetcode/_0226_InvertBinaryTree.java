package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0226_InvertBinaryTree {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<TreeNode> all = new ArrayList<>();
            all.add(root);
            while (!all.isEmpty()) {
                TreeNode curValue = all.remove(all.size() - 1);
                if (curValue.left != null || curValue.right != null) {
                    TreeNode tmp = curValue.left;
                    curValue.left = curValue.right;
                    curValue.right = tmp;
                }
                if (curValue.left != null) {
                    all.add(curValue.left);
                }
                if (curValue.right != null) {
                    all.add(curValue.right);
                }
            }
            return root;
        }
    }

    /**
     * 递归
     */
    class Solution0 {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.left == null && root.right == null) {
                return root;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
