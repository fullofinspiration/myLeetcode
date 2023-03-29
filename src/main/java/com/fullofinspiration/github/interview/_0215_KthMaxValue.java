package com.fullofinspiration.github.interview;

/**
 * 力扣215
 */
public class _0215_KthMaxValue {

  class Solution {
    public int findKthLargest(int[] nums, int k) {
      int kth = nums.length - k;
      int low = 0, high = nums.length - 1;
      while (low <= high) {
        int partition = partition(nums, low, high);
        if (partition == kth) {
          return nums[partition];
        } else if (partition < kth) {
          low = partition + 1;
        } else {
          high = partition - 1;
        }
      }
      throw new IllegalStateException();
    }

    /**
     * 第0个元素对应索引
     */
    private int partition(int[] nums, int low, int high) {
      int pivotNum = nums[low];
      while (low < high) {
        while (low < high && nums[high] >= pivotNum) {
          high--;
        }
        nums[low] = nums[high];
        while (low < high && nums[low] < pivotNum) {
          low++;
        }
        nums[high] = nums[low];
      }
      nums[low] = pivotNum;
      return low;
    }
  }

  class Solution00 {
    public int findKthLargest(int[] nums, int k) {
      int low = 0, high = nums.length - 1;
      while (low <= high) {
        int curlow = low, curhigh = high;
        int cur = nums[curlow];
        while (curlow < curhigh) {
          while (curhigh > curlow && nums[curhigh] >= cur) {
            curhigh--;
          }
          nums[curlow] = nums[curhigh];
          while (curhigh > curlow && nums[curlow] < cur) {
            curlow++;
          }
          nums[curhigh] = nums[curlow];
        }
        nums[curlow] = cur;
        int idx = nums.length - k;
        if (curlow == idx) {
          return nums[curlow];
        } else if (curlow > idx) {
          high = curlow - 1;
        } else {
          low = curlow + 1;
        }
      }
      throw new IllegalStateException();
    }
  }

}
