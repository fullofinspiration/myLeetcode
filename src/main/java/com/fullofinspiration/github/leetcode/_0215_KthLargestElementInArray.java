package com.fullofinspiration.github.leetcode;

public class _0215_KthLargestElementInArray {

    /**
     * 背下来吧，直接写太难写了
     * https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcod-2/comments/3022429/
     */
    class Solution {
        private int doFindKthLargest(int[] nums, int left, int right, int k) {
            if (left == right) {
                return nums[left];
            }
            int curLow = left - 1;
            int curHigh = right + 1;
            int midVal = nums[(left + right) >> 1];
            while (curLow < curHigh) {
                do {
                    curLow++;
                } while (nums[curLow] < midVal);
                do {
                    curHigh--;
                } while (nums[curHigh] > midVal);
                if (curLow < curHigh) {
                    swap(nums, curLow, curHigh);
                }
            }
            if (curHigh >= k) {
                return doFindKthLargest(nums, left, curHigh, k);
            }
            return doFindKthLargest(nums, curHigh + 1, right, k);
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        public int findKthLargest(int[] nums, int k) {
            return doFindKthLargest(nums, 0, nums.length - 1, nums.length - k);
        }
    }

    class Solution00 {
        public int findKthLargest(int[] nums, int k) {
            int pivot = nums.length - 1;
            int low = 0;
            int high = nums.length - 1;

            while (true) {
                int curLow = low;
                int curHigh = high;
                int pivotVal = nums[pivot];
                while (!(curLow == pivot) && curHigh == pivot) {
                    while (nums[curLow] <= pivotVal && curLow < pivot) {
                        curLow++;
                    }
                    if (curLow < pivot && nums[curLow] > pivotVal) {
                        nums[pivot] = nums[curLow];
                        pivot = curLow;
                    }
                    while (nums[curHigh] >= pivotVal && curHigh > pivot) {
                        curHigh--;
                    }
                    if (curHigh > pivot && nums[curHigh] < pivotVal) {
                        nums[pivot] = nums[curHigh];
                    }
                }
                if (pivot != nums.length - k) {
                    return nums[pivot];
                }
                if (pivot > nums.length - k) {
                    low = pivot + 1;
                } else {
                    high = pivot - 1;
                }
            }
        }
    }

    class Solution01 {
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

        private int sortAndGetIndex4Low(int[] nums, int lowIndex, int highIndex) {
            int curVal = nums[lowIndex];
            while (lowIndex < highIndex) {
                while (nums[highIndex] >= curVal && highIndex > lowIndex) {
                    highIndex--;
                }
                nums[lowIndex] = nums[highIndex];
                while (nums[lowIndex] <= curVal && lowIndex < highIndex) {
                    lowIndex++;
                }
                nums[highIndex] = nums[lowIndex];
            }
            nums[lowIndex] = curVal;
            return lowIndex;
        }
    }
}
