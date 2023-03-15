package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.*;

public class _0094_BinaryTreeInorderTraversal {
    /**
     * 这是我自己写出来的，和最简单的方法完全一样：https://leetcode.com/problems/binary-tree-inorder-traversal/solutions/31213/iterative-solution-in-java-simple-and-readable/?orderBy=most_votes
     * 使用栈的原因：先输出离着最近的元素，再输出离着远的元素
     * 栈中元素：没有输出，右节点没有被遍历
     * 1 cur = root
     * 2 while cur !=null, add to stack, cur = cur.left
     * 3 pop and 1)add to rst, cur = cur.right
     * 4 直到stack为null为止
     * debug出的问题：
     * 第一层终止条件写成了cur== null,实际遍历到右节点，然后遍历到左节点时，cur最终是null的，终止条件只应该为stack为empty
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<TreeNode> roots = new LinkedList<>();
            List<Integer> rst = new ArrayList<>();
            TreeNode cur = root;
            while (true) {
                while (cur != null) {
                    roots.push(cur);
                    cur = cur.left;
                }
                if (roots.isEmpty()) {
                    return rst;
                }
                TreeNode pop = roots.pop();
                rst.add(pop.val);
                cur = pop.right;
            }
        }
    }

    class Solution00 {
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
