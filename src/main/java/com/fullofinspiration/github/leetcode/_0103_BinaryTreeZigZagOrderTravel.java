package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _0103_BinaryTreeZigZagOrderTravel {

    class Solution {
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
