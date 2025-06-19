package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0437_NodeSum {
    /**
     * 开始时间：16:58
     * 17:38 暂停
     * 17:53继续
     * 结束时间：18:51
     * 共 1.5h
     * 是在太复杂了
     */
    class Solution {
        // 前缀和+个数
        private Map<Long, Integer> prefix = new HashMap<>();
        private int targetSum;

        public int pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            prefix.put(0L, 1);
            return traceback(root, 0);
        }

        private int traceback(TreeNode node, long current) {
            if (node == null) {
                return 0;
            }
            current += node.val;
            int count = prefix.getOrDefault(current-targetSum, 0);
            Integer prefixCount = prefix.getOrDefault(current, 0);
            prefix.put(current, prefixCount + 1);

            count += traceback(node.left, current);
            count += traceback(node.right, current);
            prefix.put(current, prefixCount);
            return count;
        }
    }
}
