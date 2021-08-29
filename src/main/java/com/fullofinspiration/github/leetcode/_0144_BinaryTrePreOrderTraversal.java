package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _0144_BinaryTrePreOrderTraversal {
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> all = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            all.add(root.val);
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                while (node.left != null) {
                    node = node.left;
                    all.add(node.val);
                    stack.push(node);
                }
                while (!stack.isEmpty() && stack.peek().right == null) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    node = stack.pop().right;
                    all.add(node.val);
                    stack.push(node);
                }
            }
            return all;
        }
    }

    class Solution1 {
        private final List<Integer> all = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            all.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return all;
        }
    }
}
