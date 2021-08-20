package com.fullofinspiration.github.leetcode;

public class _0088_MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n == 0) {
                return;
            }
            int curPosition = nums1.length - 1;
            int firstIndex = m - 1;
            int secondIndex = n - 1;
            while (curPosition >= 0) {
                if (secondIndex < 0 || (firstIndex >= 0 && nums1[firstIndex] >= nums2[secondIndex])) {
                    nums1[curPosition--] = nums1[firstIndex--];
                } else {
                    nums1[curPosition--] = nums2[secondIndex--];
                }
            }
        }
    }
}
