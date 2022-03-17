package com.fullofinspiration.github.interview;

import java.util.LinkedList;

/**
 * 滴滴
 */
public class BinaryTreeAdderOfOdd {
    public int sumOddOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rst = 0;
        int total = 1;
        LinkedList<TreeNode> all = new LinkedList<>();
        all.add(root);
        while (!all.isEmpty()) {
            int nums = all.size();
            while (nums > 0) {
                TreeNode curNode = all.removeLast();
                nums--;
                if (curNode.left != null) {
                    all.addFirst(curNode.left);
                    total++;
                    if (total % 2 == 0) {
                        rst += curNode.left.val;
                    }
                }
                if (curNode.right != null) {
                    total++;
                    all.addFirst(curNode.right);
                    if (total % 2 == 0) {
                        rst += curNode.right.val;
                    }
                }
            }
        }
        return rst;
    }


    private class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
