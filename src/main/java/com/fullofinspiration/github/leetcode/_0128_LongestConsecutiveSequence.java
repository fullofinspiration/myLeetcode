package com.fullofinspiration.github.leetcode;


import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> all = new HashSet<>();
            for (int num : nums) {
                all.add(num);
            }
            int ret = 0;
            for (int num: all) {
                if (all.contains(num - 1)) {
                    continue;
                }
                int curNum=num;
                while (all.contains(curNum)) {
                   curNum++;
                }
                ret = Math.max(ret, curNum-num);
            }
            return ret;
        }
    }

    /**
     * 运行超时
     */
    class Solution01 {
        public int longestConsecutive(int[] nums) {
            int ret = 0;
            Set<Integer> all = new HashSet<>();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                all.add(nums[i]);
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
            int start = min;
            int end = min;
            while (end <= max) {
                if (!all.contains(end)) {
                    end = end + 1;
                    start = end;
                    continue;
                }
                int curLen = end - start + 1;
                ret = Math.max(ret, curLen);
                end++;
            }
            return ret;
        }
    }

    /**
     * TreeMap<Integer, Integer> low2Size;
     * int max = 0;
     * for(int i=0;i<nums.size();i++){
     * int size = 1;
     * Entry<Integer,Integer> low = low2Size.getLower(nums[i]);
     * if (low == null || low.getKey() + low.getValue()-1 < nums[i]) {
     * Entry<Integer,Integer> high = low2Size.getHigher(nums[i]);
     * if (high == null || high.getKey()-1> nums[i]) {
     * low2Size.put(nums[i], 1);
     * } else {
     * size  = high +1;
     * low2Size.put(nums[i], ++high);
     * if (high > max) {
     * }
     * } else {
     * if (low.getKey() + low.getValue - 1 >= nums[i]) {
     * //看两个间断区间是否可以合并成一个区间
     * if (low2Size.get(nums[i]) != null) {
     * size = low.getValue() + low2Size.get(nums[i]) +1;
     * low2Size.put(low.getKey, size);
     * low2Size.remove(nums[i]);
     * } else {
     * size = low.getValue + 1;
     * low2Size.put(low.getKey, size);
     * }
     * } else {
     * low2Size.put(nums[i], 1);
     * }
     * }
     * return max;
     * }
     */
    class Solution00 {
        public int longestConsecutive(int[] nums) {
            return -1;
        }
    }
}
