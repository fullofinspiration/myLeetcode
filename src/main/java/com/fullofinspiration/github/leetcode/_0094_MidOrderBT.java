package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _0094_MidOrderBT {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            Deque<TreeNode> all = new ArrayDeque<>();
            while (root != null || !all.isEmpty()) {
                while (root != null) {
                    all.push(root);
                    root = root.left;
                }
                root = all.pop();
                ret.add(root.val);
                root = root.right;
            }
            return ret;
        }
    }
}
