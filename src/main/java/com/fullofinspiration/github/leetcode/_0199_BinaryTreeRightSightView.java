package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _0199_BinaryTreeRightSightView {
    /**
     * 开始时间20:43
     * 结束时间20:58
     * 15min
     *
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> rets = new ArrayList<>();
            LinkedList<TreeNode> all = new LinkedList<>();
            all.add(root);
            int curSize = 1;
            while (!all.isEmpty()) {
                TreeNode treeNode = all.removeFirst();
                if (treeNode.left != null) {
                    all.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    all.add(treeNode.right);
                }
                if (--curSize == 0) {
                    rets.add(treeNode.val);
                    curSize = all.size();
                }
            }
            return rets;
        }
    }

    class Solution00 {
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
