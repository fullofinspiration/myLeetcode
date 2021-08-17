package com.fullofinspiration.github.leetcode;

public class _0215_KthLargestElementInArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int curVal;
            int low = 0;
            int high = nums.length - 1;
            while (true) {
                curVal = nums[low];
                int targetIndex = sortAndGetIndex4Low(nums, low, high);
                if (targetIndex == nums.length - k) {
                    return curVal;
                } else if (targetIndex < nums.length - k) {
                    low = targetIndex + 1;
                } else {
                    high = targetIndex - 1;
                }
            }
        }

        private int sortAndGetIndex4Low(int[] nums, int low, int high) {
            int lowIndex = low;
            int highIndex = high;
            int curVal = nums[lowIndex];
            while (lowIndex < highIndex) {
                while (nums[highIndex] >= curVal && highIndex > low) {
                    highIndex--;
                }
                if (highIndex <= lowIndex) {
                    break;
                }
                nums[lowIndex++] = nums[highIndex];
                while (nums[lowIndex] <= curVal && lowIndex < high) {
                    lowIndex++;
                }
                if (lowIndex >= highIndex) {
                    lowIndex = highIndex;
                    break;
                }
                nums[highIndex--] = nums[lowIndex];
            }
            nums[lowIndex] = curVal;
            return lowIndex;
        }
    }
}
