package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *TODO 递归的方法后面有时间看看
 */
public class _0236_LowestCommonAncestorOfBinaryTree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Map<TreeNode, TreeNode> node2Parent = new HashMap<>();
            node2Parent.put(root, null);
            buildMap(node2Parent, root);
            return getIntersectionNode(p, q, node2Parent);
        }

        private TreeNode getIntersectionNode(TreeNode headA, TreeNode headB, Map<TreeNode, TreeNode> node2Parent) {
            TreeNode first = headA;
            TreeNode second = headB;
            while (first != null && second != null) {
                first = node2Parent.get(first);
                second = node2Parent.get(second);
            }
            TreeNode graterBegin;
            TreeNode shorterBegin;
            TreeNode graterMid;
            if (first != null) {
                graterBegin = headA;
                graterMid = first;
                shorterBegin = headB;

            } else {
                shorterBegin = headA;
                graterMid = second;
                graterBegin = headB;
            }
            while (graterMid != null) {
                graterBegin = node2Parent.get(graterBegin);
                graterMid = node2Parent.get(graterMid);
            }
            while (shorterBegin != null && shorterBegin != graterBegin) {
                shorterBegin = node2Parent.get(shorterBegin);
                graterBegin = node2Parent.get(graterBegin);
            }
            return shorterBegin;
        }

        private void buildMap(Map<TreeNode, TreeNode> node2Parent, TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.left != null) {
                node2Parent.put(node.left, node);
                buildMap(node2Parent, node.left);
            }
            if (node.right != null) {
                node2Parent.put(node.right, node);
                buildMap(node2Parent, node.right);
            }
        }
    }
}
