package com.fullofinspiration.github.leetcode;

public class _0704_BinarySearch {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                if (target < nums[low] || target > nums[high]) {
                    return -1;
                }
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }
    }
}
