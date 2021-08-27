package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0199_BinaryTreeRightSightView {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> all = new ArrayList<>();
            if (root == null) {
                return all;
            }
            LinkedList<TreeNode> first = new LinkedList<>();
            LinkedList<TreeNode> second = new LinkedList<>();
            first.add(root);
            while (!first.isEmpty()) {
                transverse(all, second, first);
                transverse(all, first, second);
            }
            return all;
        }

        private void transverse(List<Integer> all, LinkedList<TreeNode> toBeAdded, LinkedList<TreeNode> toBeRemoved) {
            while (!toBeRemoved.isEmpty()) {
                TreeNode remove = toBeRemoved.remove();
                if (remove.left != null) {
                    toBeAdded.add(remove.left);
                }
                if (remove.right != null) {
                    toBeAdded.add(remove.right);
                }
                if (toBeRemoved.isEmpty()) {
                    all.add(remove.val);
                }
            }
        }
    }
}
