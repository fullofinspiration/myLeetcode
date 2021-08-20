package com.fullofinspiration.github.leetcode;

/**
 * 自己写的其他解法有空再看
 */
public class _0033_SearchRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                if (nums[low] <= nums[high]) {
                    if (target < nums[low] || target > nums[high]) {
                        return -1;
                    }
                    int midIndex = (low + high) / 2;
                    if (nums[midIndex] == target) {
                        return midIndex;
                    } else if (nums[midIndex] > target) {
                        high = midIndex - 1;
                    } else {
                        low = midIndex + 1;
                    }
                } else {
                    if (target > nums[high] && target < nums[low]) {
                        return -1;
                    }
                    int midIndex = (low + high) / 2;
                    if (nums[midIndex] == target) {
                        return midIndex;
                    }
                    if (nums[low] < nums[midIndex] && target >= nums[low] && target < nums[midIndex]) {
                        high = midIndex - 1;
                    } else if (nums[low] > nums[midIndex] && (target >= nums[low] || target < nums[midIndex])) {
                        high = midIndex - 1;
                    } else {
                        low = midIndex + 1;
                    }
                }
            }
            return -1;
        }
    }

    public static void main1(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        search(array, 0);
    }

    /**
     * 我的解法很繁琐，非常费时间，容易出错，根本没必要写两个函数，因为第一个
     * 函数已经有了二分查找的思想，所以没必要写两个
     * 而答案中的解法真的一点不拖泥带水
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target && nums[low] <= target) {
                return binarySearch(nums, target, low, mid - 1);
            }
            if (nums[mid] > target && nums[low] >= target) {
                if (nums[low] > nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if (nums[mid] < target && nums[high] >= target) {
                return binarySearch(nums, target, mid + 1, high);
            }
            if (nums[mid] < target && nums[high] <= target) {
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }


}
