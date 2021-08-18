package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> all = new ArrayList<>();
            //可以直接写Arrays.sort
            //Arrays.sort(nums);
            quickSort(nums, 0, nums.length - 1);
            for (int left = 0; left < nums.length; left++) {
                if (left > 0 && nums[left] == nums[left - 1]) {
                    continue;
                }
                int mid = left + 1;
                int right = nums.length - 1;
                while (mid < right) {
                    int curSum = nums[left] + nums[mid] + nums[right];
                    if (curSum == 0) {
                        List<Integer> results = Arrays.asList(nums[left], nums[mid], nums[right]);
                        all.add(results);
                        mid++;
                        right--;
                        while (mid < right && nums[mid] == nums[left]) {
                            mid++;
                        }
                        while (mid < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                    } else if (curSum < 0) {
                        mid++;
                    } else {
                        right--;
                    }
                }
            }
            return all;
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

    /**
     * 太他娘的繁琐了.
     */
    public static List<List<Integer>> threeSum01(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int curSum = nums[i] + nums[j] + nums[k];
                if (curSum > 0) {
                    k--;
                } else if (curSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }
                    j++;
                    k--;

                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
