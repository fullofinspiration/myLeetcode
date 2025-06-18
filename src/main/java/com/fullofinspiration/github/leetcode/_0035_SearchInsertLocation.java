package com.fullofinspiration.github.leetcode;

public class _0035_SearchInsertLocation {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int targetIdx = nums.length;
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] >= target) {
                    targetIdx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return targetIdx;
        }
    }
}
