package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.LinkedList;

/**
 * @formatter:off
 * @formatter:on
 */
public class _0101_SymmetricTree {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left == null && root.right == null) {
                return true;
            }
            if (root.left == null) {
                return false;
            }
            if (root.right == null) {
                return false;
            }
            if (root.left.val != root.right.val) {
                return false;
            }
            LinkedList<TreeNode> left = new LinkedList<>();
            left.add(root.left);
            LinkedList<TreeNode> right = new LinkedList<>();
            right.add(root.right);
            while (!left.isEmpty()) {
                TreeNode leftNode = left.removeLast();
                TreeNode rightNode = right.removeLast();
                if (leftNode.val != rightNode.val) {
                    return false;
                }
                if (leftNode.left != null && rightNode.right != null) {
                    left.add(leftNode.left);
                    right.add(rightNode.right);
                } else if (!(leftNode.left == null && rightNode.right == null)) {
                    return false;
                }
                if (leftNode.right != null && rightNode.left != null) {
                    left.add(leftNode.right);
                    right.add(rightNode.left);
                } else if (!(leftNode.right == null && rightNode.left == null)) {
                    return false;
                }
            }
            return true;
        }
    }

    //递归算法
    class Solution0 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null) {
                return false;
            }
            if (right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }

}
