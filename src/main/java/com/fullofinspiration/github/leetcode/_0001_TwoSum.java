package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * easy
 */
public class _0001_TwoSum {
    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> value2Index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int delta = target - nums[i];
                if (value2Index.containsKey(delta)) {
                    return new int[]{i, value2Index.get(delta)};
                }
                value2Index.put(nums[i], i);
            }
            throw new IllegalStateException();
        }
    }

    /**
     * 时间复杂度O(n), 空间复杂度O(n)
     */
    class Solution04 {

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> value2Index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                value2Index.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int delta = target - nums[i];
                if (value2Index.containsKey(delta) && value2Index.get(delta) != i) {
                    return new int[]{value2Index.get(delta), i};
                }
            }
            throw new IllegalStateException();
        }
    }

    /**
     * 时间复杂度O(n^2) 空间复杂度O(1)
     */
    class Solution03 {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            throw new IllegalStateException();
        }
    }

    class Solution02 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> num2Idx = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                num2Idx.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int val = target - nums[i];
                if (num2Idx.containsKey(val) && num2Idx.get(val) != i) {
                    return new int[]{num2Idx.get(val), i};
                }
            }
            throw new IllegalStateException();
        }
    }

    /**
     * 1 Arrays.sort()
     * 2 双指针
     */
    class Solution01 {
        public int[] twoSum(int[] nums, int target) {
            return new int[]{0, 1};
        }
    }

    /**
     * 空间换时间 空间复杂度O(n) 时间复杂度O(n)
     */
    class Solution00 {
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
