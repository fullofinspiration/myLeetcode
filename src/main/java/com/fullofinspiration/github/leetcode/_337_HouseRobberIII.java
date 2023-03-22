package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _337_HouseRobberIII {
    /**
     * 自底向上，直到遍历到根节点
     * 1 cur=Math.max(left+right, cur+Math.max(left.left,left.right)+Math.max(right.left, right.right)
     * 错误1 公式写错了，之前是：cur=Math.max(left+right, cur+Math.max(left.left,left.right)+Math.max(right.left, right.right)
     * 应该是：cur=Math.max(left+right, cur+left.left+left.right+right.left, right.right)
     * 2 超出内存限制，使用map保存中间结果
     */
    class Solution {
        Map<TreeNode, Integer> node2Val = new HashMap<>();

        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (node2Val.containsKey(root)) {
                return node2Val.get(root);
            }
            int max1 = rob(root.left) + rob(root.right);
            int leftMax = root.left == null ? 0 : rob(root.left.left) + rob(root.left.right);
            int rightMax = root.right == null ? 0 : rob(root.right.left) + rob(root.right.right);
            int rst = Math.max(max1, root.val + leftMax + rightMax);
            node2Val.putIfAbsent(root, rst);
            return rst;
        }
    }
}
