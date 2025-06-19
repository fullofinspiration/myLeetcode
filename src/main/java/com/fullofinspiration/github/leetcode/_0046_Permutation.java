package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0046_Permutation {

    /**
     开始时间:7:50
     结束时间:8:25
     */
    class Solution {

        int[] nums;
        List<List<Integer>> rets = new ArrayList<>();
        List<Integer> partRets = new ArrayList<>();

        boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            this.visited = new boolean[nums.length];
            backtrace(0);
            return rets;
        }

        /**
         * @param idx 当前要处理的索引
         */
        private void backtrace(int idx) {
            if (partRets.size() == nums.length) {
                rets.add(new ArrayList<>(partRets));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                partRets.add(nums[i]);
                visited[i] = true;
                backtrace(idx + 1);
                partRets.remove(partRets.size() - 1);
                visited[i] = false;
            }

        }
    }

    /**
     * 典型的回溯问题
     * https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/?orderBy=most_votes
     * 时间复杂度：O(n!) 空间复杂度O(1)，使用递归
     * 1 遍历所有元素，若当前元素未加入，则添加进去，直到遍历完所有元素
     * 错误1: remove方法入参应该是idx而不是value
     */
    class Solution01 {

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
                cur.remove(cur.size() - 1);
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
