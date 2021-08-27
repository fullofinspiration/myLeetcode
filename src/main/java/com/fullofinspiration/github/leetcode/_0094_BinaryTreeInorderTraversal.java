package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _0094_BinaryTreeInorderTraversal {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<Integer> all = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                while (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                }
                while (stack.peek() != null) {
                    TreeNode node4Print = stack.pop();
                    all.add(node4Print.val);
                    if (node4Print.right == null) {
                        continue;
                    }
                    stack.push(node4Print.right);
                    break;
                }
            }
            return all;
        }
    }

    /**
     * 递归
     */
    class Solution0 {
        List<Integer> all = new LinkedList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            inorderTraversal(root.left);
            all.add(root.val);
            inorderTraversal(root.right);
            return all;
        }
    }
}
