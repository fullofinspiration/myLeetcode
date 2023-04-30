package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047_PermutationsII {
    /**
     * https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning/?orderBy=most_votes
     * 题目读懂很麻烦：
     * 比如[1,1,2]
     * [1(idx=0),1(idx=1),2] [1(idx=1),1(idx=0),2],需要将第二种case去除掉
     * 方式是：假如nums[i] == nums[i-1],假如i-1使用过，则保留，否则就不保留
     */
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> all = new ArrayList<>();
            backtrace(all, nums, new boolean[nums.length], new ArrayList<>());
            return all;
        }

        private void backtrace(List<List<Integer>> all, int[] nums, boolean[] visited, List<Integer> tmpList) {
            if (tmpList.size() == nums.length) {
                all.add(new ArrayList<>(tmpList));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                }
                tmpList.add(nums[i]);
                visited[i] = true;
                backtrace(all, nums, visited, tmpList);
                tmpList.remove(tmpList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
