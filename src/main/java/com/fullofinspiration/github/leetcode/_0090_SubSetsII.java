package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0090_SubSetsII {
    /**
     * https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/
     * <p>
     * 问题
     * 1：remove时应该remove最后一个节点，开始写的tmpList.remove(nums[i])
     * 2：不满足条件应该continue，开始写的i+1
     * 3: 起始遍历节点应该是i+1而不是idx
     *
     */
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> all = new ArrayList<>();
            backtrace(all, nums, new ArrayList<>(), 0);
            return all;
        }

        private void backtrace(List<List<Integer>> all, int[] nums, List<Integer> tmpList, int idx) {
            System.out.println(tmpList);
            all.add(new ArrayList<>(tmpList));
            for (int i = idx; i < nums.length; i++) {
                if (i > idx && nums[i] == nums[i - 1]) {
                    continue;
                }
                tmpList.add(nums[i]);
                backtrace(all, nums, tmpList, i + 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}

