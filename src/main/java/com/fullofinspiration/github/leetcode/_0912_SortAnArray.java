package com.fullofinspiration.github.leetcode;

public class _0912_SortAnArray {
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int low, int high) {
            if (low >= high) {
                return;
            }
            int left = low;
            int right = high;
            int curVal = nums[left];
            while (left < right) {
                while (nums[right] >= curVal && right > left) {
                    right--;
                }
                nums[left] = nums[right];
                while (nums[left] <= curVal && left < right) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = curVal;
            quickSort(nums, low, left - 1);
            quickSort(nums, left + 1, high);
        }
    }
}
