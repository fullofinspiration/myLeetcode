package com.fullofinspiration.github.leetcode;

public class _0189_MoveKInArray {
    /**
     * https://leetcode.cn/problems/rotate-array/solutions/683855/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            if (k < 1) {
                return;
            }
            k = k % nums.length;
            handle(nums, 0, nums.length - 1);
            handle(nums, 0, k - 1);
            handle(nums, k, nums.length - 1);
        }

        private void handle(int[] nums, int low, int high) {
            while (low < high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }

        private void swap(int[] nums, int low, int high) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
        }
    }
}
