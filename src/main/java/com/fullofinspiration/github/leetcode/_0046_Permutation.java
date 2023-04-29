package com.fullofinspiration.github.leetcode;

import java.util.*;

/**
 * 后面再看其他解法
 */
public class _0046_Permutation {
    /**
     * 典型的回溯问题
     * https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/?orderBy=most_votes
     * 时间复杂度：O(n!) 空间复杂度O(1)，使用递归
     * 1 遍历所有元素，若当前元素未加入，则添加进去，直到遍历完所有元素
     * 错误1: remove方法入参应该是idx而不是value
     */
    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> all = new ArrayList<>();
            traverse(all, nums, new ArrayList<>());
            return all;
        }

        private void traverse(List<List<Integer>> all, int[] nums, List<Integer> cur) {
            if (cur.size() == nums.length) {
                all.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (cur.contains(nums[i])) {
                    continue;
                }
                cur.add(nums[i]);
                traverse(all, nums, cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    class Solution00 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> all = new ArrayList<>();
            Queue<List<Integer>> queue = new LinkedList<>();
            queue.add(new ArrayList<>());
            while (!queue.isEmpty()) {
                List<Integer> curList = queue.remove();
                for (int i = 0; i < nums.length; i++) {
                    if (curList.contains(nums[i])) {
                        continue;
                    }
                    ArrayList<Integer> curValues = new ArrayList<>(curList);
                    curValues.add(nums[i]);
                    if (curValues.size() == nums.length) {
                        all.add(curValues);
                    } else {
                        queue.add(curValues);
                    }
                }
            }
            return all;
        }
    }

}
