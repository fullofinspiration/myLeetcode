package com.fullofinspiration.github.leetcode;

/**
 * 使用set，在插入过程中，只要有重复的就移除，最多需要O(n)的空间复杂度，一般需要常量时间复杂度
 * Set<Integer> singles = Sets.new HashSet();
 * for(int i = 0, i < nums.length; i++) {
 * if (singles.contains(nums[i])) {
 * singles.remove(nums[i]);
 * } else {singles.add(nums[i]);
 * }
 * singles.iterator();
 * return singles.next();
 * }
 */
public class _0136_SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int ret = 0;
            for (int num : nums) {
                ret ^= num;
            }
            return ret;
        }
    }

    class Solution00 {
        public int singleNumber(int[] nums) {
            int target = 0;
            for (int num : nums) {
                target ^= num;
            }
            return target;
        }
    }
}
