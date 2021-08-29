package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.*;

public class _0113_PathSum2 {
    class Solution {
        private Map<TreeNode, TreeNode> node2Parent = new HashMap<>();
        private List<TreeNode> allLeafs = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> all = new ArrayList<>();
            if (root == null) {
                return Collections.emptyList();
            }
            node2Parent.put(root, null);
            traverse(root);

            for (TreeNode leaf : allLeafs) {
                TreeNode curNode = leaf;
                List<Integer> subResult = new ArrayList<>();
                int curSum = 0;
                while (curNode != null) {
                    subResult.add(curNode.val);
                    curSum += curNode.val;
                    curNode = node2Parent.get(curNode);
                }
                if (curSum == targetSum) {
                    Collections.reverse(subResult);
                    all.add(subResult);
                }
            }
            return all;
        }

        private void traverse(TreeNode treeNode) {
            if (treeNode.left != null) {
                node2Parent.put(treeNode.left, treeNode);
                traverse(treeNode.left);
            }
            if (treeNode.right != null) {
                node2Parent.put(treeNode.right, treeNode);
                traverse(treeNode.right);
            }
            if (treeNode.left == null && treeNode.right == null) {
                allLeafs.add(treeNode);
            }
        }
    }
}
