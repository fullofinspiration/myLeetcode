package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
public class _0102_BinaryTreeLevelOrderTraversal {
    class Solution {
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
