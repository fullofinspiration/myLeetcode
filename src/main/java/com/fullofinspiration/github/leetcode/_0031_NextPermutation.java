package com.fullofinspiration.github.leetcode;

public class _0031_NextPermutation {
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int lessThanNextIndex = nums.length - 2;
            while (lessThanNextIndex >= 0 && nums[lessThanNextIndex] >= nums[lessThanNextIndex + 1]) {
                lessThanNextIndex--;
            }
            int j = nums.length - 1;
            while (lessThanNextIndex >= 0 && j > lessThanNextIndex && nums[j] <= nums[lessThanNextIndex]) {
                j--;
            }
            if (lessThanNextIndex != -1) {
                int temp = nums[lessThanNextIndex];
                nums[lessThanNextIndex] = nums[j];
                nums[j] = temp;
            }

            int low = lessThanNextIndex + 1;
            int high = nums.length - 1;
            while (low < high) {
                int temp = nums[low];
                nums[low++] = nums[high];
                nums[high--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int maxIndex = nums.length - 1;
        int minIndex = maxIndex;
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex--;
            } else {
                int j = maxIndex;
                while (j < minIndex && nums[j + 1] > nums[i]) {
                    j++;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                break;
            }
        }
        while (maxIndex < minIndex) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[minIndex];
            nums[minIndex] = temp;
            maxIndex++;
            minIndex--;
        }
    }

}
