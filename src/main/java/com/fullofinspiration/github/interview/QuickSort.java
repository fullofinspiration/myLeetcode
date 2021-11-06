package com.fullofinspiration.github.interview;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    static void quickSort(int[] nums, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int low = lowIndex;
        int high = highIndex;
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }

            if (low < high) {
                nums[low++] = nums[high];
            }
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            if (low < high) {
                nums[high--] = nums[low];
            }
        }
        nums[low] = pivot;
        quickSort(nums, lowIndex, low - 1);
        quickSort(nums, low + 1, highIndex);
    }


}
