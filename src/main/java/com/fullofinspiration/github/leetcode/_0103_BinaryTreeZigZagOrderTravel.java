package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.*;

public class _0103_BinaryTreeZigZagOrderTravel {
    /**
     * 主要是自己想出来的，也参考了https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/33904/java-double-stack-solution/?orderBy=most_votes
     * 1 从两个栈来回倒腾，因为都是后进先出的
     * 2 第2个栈：1)second.push(first.left) 2) second.push(first.right)
     * 3 第一个栈：1）first.push(second.right) 2) first.push(second.left)
     * 4 终止条件：栈为空
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Stack<TreeNode> first = new Stack<>();
            first.add(root);
            Stack<TreeNode> second = new Stack<>();
            List<List<Integer>> rst = new ArrayList<>();
            while (!first.isEmpty()) {
                List<Integer> cur = new ArrayList<>();
                while (!first.isEmpty()) {
                    TreeNode pop = first.pop();
                    cur.add(pop.val);
                    if (pop.left != null) {
                        second.add(pop.left);
                    }
                    if (pop.right != null) {
                        second.add(pop.right);
                    }
                }
                rst.add(cur);
                cur = new ArrayList<>();
                while (!second.isEmpty()) {
                    TreeNode pop = second.pop();
                    cur.add(pop.val);
                    if (pop.right != null) {
                        first.add(pop.right);
                    }
                    if (pop.left != null) {
                        first.add(pop.left);
                    }
                }
                if (cur.size() != 0) {
                    rst.add(cur);
                }
            }
            return rst;
        }
    }

    /**
     * 1 每次都入栈，而不是队列
     * 2 奇数先入右再入左，偶数先入左再入右，直到栈为空
     * 这种方式太绕了，没写完，还是放弃
     */
    class Solution01 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> all = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            int curLevel = 0;
            while (!stack.isEmpty()) {
                int size4CurLevel = stack.size();
                List<Integer> val4CurLevel = new ArrayList<>();
                while (size4CurLevel-- > 0) {
                    TreeNode pop = stack.pop();
                    val4CurLevel.add(pop.val);
                    if (curLevel % 2 != 0) {
                        if (pop.right != null) {
                            stack.push(pop.right);
                        }
                        if (pop.left != null) {
                            stack.push(pop.left);
                        }
                    } else {
                        if (pop.left != null) {
                            stack.push(pop.left);
                        }
                        if (pop.right != null) {
                            stack.push(pop.right);
                        }
                    }
                    all.add(val4CurLevel);
                    curLevel++;
                }
            }
            return all;
        }
    }

    class Solution00 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            LinkedList<TreeNode> ascStack = new LinkedList<>();
            LinkedList<TreeNode> descStack = new LinkedList<>();
            ascStack.add(root);
            List<List<Integer>> all = new ArrayList<>();
            while (true) {
                if (ascStack.isEmpty()) {
                    break;
                }
                List<Integer> ascValues = new ArrayList<>();
                while (!ascStack.isEmpty()) {
                    TreeNode firstNode = ascStack.pop();
                    ascValues.add(firstNode.val);
                    if (firstNode.left != null) {
                        descStack.push(firstNode.left);
                    }
                    if (firstNode.right != null) {
                        descStack.push(firstNode.right);
                    }
                }
                all.add(ascValues);

                if (descStack.isEmpty()) {
                    break;
                }
                List<Integer> descValues = new ArrayList<>();
                while (!descStack.isEmpty()) {
                    TreeNode descNode = descStack.pop();
                    descValues.add(descNode.val);
                    if (descNode.right != null) {
                        ascStack.push(descNode.right);
                    }
                    if (descNode.left != null) {
                        ascStack.push(descNode.left);
                    }
                }
                all.add(descValues);
            }
            return all;
        }
    }
}
