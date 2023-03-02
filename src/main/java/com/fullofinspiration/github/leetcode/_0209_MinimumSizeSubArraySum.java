package com.fullofinspiration.github.leetcode;

public class _0209_MinimumSizeSubArraySum {
    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/solutions/59078/accepted-clean-java-o-n-solution-two-pointers/?orderBy=most_votes
     */
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int curMin = Integer.MAX_VALUE;
            int curSum = 0;
            int i = 0, j = 0;
            while (j < nums.length) {
                curSum += nums[j++];
//                String msg = String.format("after add high, low: %s, high: %s, curMin: %s, curSum: %s", i, j, curMin, curSum);
//                System.out.println(msg);
                while (curSum >= target) {
                    curMin = Math.min(curMin, j - i);
                    curSum -= nums[i++];
                }
//                msg = String.format("after add low,low: %s, high: %s, curMin: %s, curSum: %s", i, j, curMin, curSum);
//                System.out.println(msg);
            }
            if (curMin == Integer.MAX_VALUE) {
                return 0;
            }
            return curMin;
        }
    }

    class Solution01 {
        public int minSubArrayLen(int target, int[] nums) {
            int curMin = Integer.MAX_VALUE;
            int curSum = 0;
            for (int low = 0, high = 0; low < nums.length && high < nums.length; high++) {
                curSum += nums[high];
                if (curSum < target) {
                    continue;
                }
                String msg = String.format("after add high, low: %s, high: %s, curMin: %s, curSum: %s", low, high, curMin, curSum);
                System.out.println(msg);
                for (; curSum >= target && low <= high; low++) {
                    curMin = Math.min(curMin, high - low + 1);
                    curSum -= nums[low];
                }
                msg = String.format("after add low,low: %s, high: %s, curMin: %s, curSum: %s", low, high, curMin, curSum);
                System.out.println(msg);
            }
            if (curMin == Integer.MAX_VALUE) {
                return 0;
            }
            return curMin;
        }
    }
}
