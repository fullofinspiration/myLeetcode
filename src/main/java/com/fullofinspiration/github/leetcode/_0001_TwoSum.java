package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * easy
 */
public class _0001_TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> value2Index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int curValue = nums[i];
                if (value2Index.containsKey(target - curValue)) {
                    return new int[]{i, value2Index.get(target - curValue)};
                }
                value2Index.put(curValue, i);
            }
            return null;
        }
    }
}
