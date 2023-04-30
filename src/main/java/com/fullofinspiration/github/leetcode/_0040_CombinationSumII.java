package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0040_CombinationSumII {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> all = new ArrayList<>();
            backTrace(all, candidates, new ArrayList<>(), target, 0);
            return all;
        }

        private void backTrace(List<List<Integer>> all, int[] candidates, List<Integer> tmpList, int remain, int idx) {
            if (remain < 0) {
                return;
            }
            if (remain == 0) {
                all.add(new ArrayList<>(tmpList));
                return;
            }
            for (int i = idx; i < candidates.length; i++) {
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tmpList.add(candidates[i]);
                backTrace(all, candidates, tmpList, remain - candidates[i], i + 1);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}
