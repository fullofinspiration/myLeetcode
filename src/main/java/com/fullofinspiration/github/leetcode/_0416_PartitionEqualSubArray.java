package com.fullofinspiration.github.leetcode;

import java.util.Arrays;

public class _0416_PartitionEqualSubArray {
    class Solution {
        public boolean canPartition(int[] nums) {
            int max = 0;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            if (sum % 2 == 1) {
                return false;
            }
            int target = sum / 2;
            if (max > target) {
                return false;
            }
            boolean[] satisfies = new boolean[target + 1];
            satisfies[0] = true;
            satisfies[nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = target; j > 0; j--) {
                    int satisfiedArrayIdx = j - nums[i];
                    boolean satisfiedIncludeCur = false;
                    if (satisfiedArrayIdx >= 0) {
                        satisfiedIncludeCur = satisfies[j - nums[i]];
                    }
                    satisfies[j] |= satisfiedIncludeCur;
                }
            }
            return satisfies[target];
        }
    }

    /**
     * 数组空间复杂度较高，改为一行数组
     */
    class Solution00 {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 == 1) {
                return false;
            }
            int target = sum / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return true;
                }
                if (nums[i] > target) {
                    return false;
                }
            }
            boolean[][] satisfies = new boolean[nums.length][target + 1];
            for (int i = 0; i < nums.length; i++) {
                satisfies[i][0] = true;
            }
            satisfies[0][nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j < target + 1; j++) {
                    int satisfiedArrayIdx = j - nums[i];
                    boolean satisfiedIncludeCur = false;
                    if (satisfiedArrayIdx >= 0) {
                        satisfiedIncludeCur = satisfies[i - 1][j - nums[i]];
                    }
                    satisfies[i][j] = satisfies[i - 1][j] || satisfiedIncludeCur;
                }
            }
            return satisfies[nums.length - 1][target];

        }
    }

    /**
     * [2,2,1,1]
     * 这个测试用例过不了，看来该方式不行
     */
    class WrongSolution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            Arrays.sort(nums);

            int leftSum = nums[0];
            int rightSum = 0;
            for (int i = 1; i < nums.length; i++) {
                rightSum += nums[i];
            }
            int idx = 0;
            while (true) {
                if (leftSum == rightSum) {
                    return true;
                }
                if (leftSum > rightSum) {
                    return false;
                }
                idx++;
                if (idx >= nums.length) {
                    return false;
                }
                leftSum += nums[idx];
                rightSum -= nums[idx];
            }
        }
    }
}
