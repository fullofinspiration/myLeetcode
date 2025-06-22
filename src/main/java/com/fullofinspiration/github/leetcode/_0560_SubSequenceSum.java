package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0560_SubSequenceSum {
    /**
     * https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int sum = 0;
            int count = 0;
            Map<Integer, Integer> diff2Count = new HashMap<>();
            diff2Count.put(k, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (diff2Count.containsKey(sum)) {
                    count+=diff2Count.get(sum);
                }
                int key = sum + k;
                diff2Count.put(key, diff2Count.getOrDefault(key, 0) + 1);
            }
            return count;
        }
    }
}
