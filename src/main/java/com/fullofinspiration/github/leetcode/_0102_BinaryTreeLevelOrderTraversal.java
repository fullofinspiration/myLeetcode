package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.sql.Array;
import java.util.*;

public class _0102_BinaryTreeLevelOrderTraversal {
    /**
     * 21:40-21:48
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<List<Integer>> rets = new ArrayList<>();
            LinkedList<TreeNode> all = new LinkedList<>();
            all.add(root);
            int size = 1;
            List<Integer> cur = new ArrayList<>();
            while (!all.isEmpty()) {
                TreeNode node = all.removeFirst();
                cur.add(node.val);
                if (node.left != null) {
                    all.add(node.left);
                }
                if (node.right != null) {
                    all.add(node.right);
                }
                if (--size == 0) {
                    rets.add(cur);
                    cur = new ArrayList<>();
                    size = all.size();
                }
            }
            return rets;
        }
    }

    /**
     * 1 队列，每次都放进去
     * 2 遍历队列前算有多少个值，每次遍历完，将左右节点的值都 放进去
     * 3 直到队列为空为止
     */
    class Solution01 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            Queue<TreeNode> all = new LinkedList<>();
            all.offer(root);
            List<List<Integer>> rst = new ArrayList<>();
            while (!all.isEmpty()) {
                int size = all.size();
                List<Integer> cur = new ArrayList<>();
                while (size-- > 0) {
                    if (all.peek().left != null) {
                        all.offer(all.peek().left);
                    }
                    if (all.peek().right != null) {
                        all.offer(all.peek().right);
                    }
                    cur.add(all.poll().val);
                }
                rst.add(cur);
            }
            return rst;
        }
    }

    /**
     * List<List<Integer>> allValues = new ArrayList<>();
     * if (root == null)  {
     * return allValues;
     * }
     * List<Node> all = new ArrayList<>();
     * all.add(root);
     * while(all.size > 0) {
     * List<Integer> curValues = new ArrayList<>();
     * List<Node> nextNodes = new ArrayList();
     * for(int i=0, i< all.size();i++) {
     * Node curNode =  all.get(i);
     * curValues.add(curNode.value);
     * if (curNode.left!=null) {
     * nextNodes.add(curNode.left);
     * }
     * if (curNode.right!=null) {
     * nextNodes.add(curNode.right);
     * }
     * }
     * allValues.add(curValues);
     * all= nextNodes;
     * }
     */
    class Solution00 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            LinkedList<List<Integer>> all = new LinkedList<>();
            LinkedList<TreeNode> allNodes = new LinkedList<>();
            allNodes.add(root);
            while (!allNodes.isEmpty()) {
                List<Integer> valuesForEachLevel = new ArrayList<>();
                int sizeOfCurLevel = allNodes.size();
                while (sizeOfCurLevel > 0) {
                    TreeNode treeNode = allNodes.removeLast();
                    valuesForEachLevel.add(treeNode.val);
                    sizeOfCurLevel--;
                    if (treeNode.left != null) {
                        allNodes.addFirst(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        allNodes.addFirst(treeNode.right);
                    }
                }
                all.add(valuesForEachLevel);
            }
            return all;
        }
    }
}
