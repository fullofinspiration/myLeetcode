package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 后面再看其他解法
 */
public class _0046_Permutation {
    class Solution {
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
