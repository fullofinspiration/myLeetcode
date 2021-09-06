package com.fullofinspiration.github.leetcode;

public class _0034_FirstAndLastPositionOfElementInSortedArray {

  /**
   * 一把过，我真是太牛逼了,但是方法有点问题，太过复杂了
   */
  public int[] searchRange1(int[] nums, int target) {
    int i = 0, j = nums.length - 1, targetIndex = -1;
    while (i <= j) {
      int mid = (i + j) / 2;
      if (nums[mid] == target) {
        targetIndex = mid;
        break;
      }
      if (nums[mid] > target) {
        j = mid - 1;
      } else {
        i = mid + 1;
      }
    }
    if (targetIndex == -1) {
      return new int[]{-1, -1};
    }
    int m = targetIndex, n = targetIndex;
    while (m >= 0 && nums[m] == target) {
      m--;
    }
    while ((n < nums.length && nums[n] == target)) {
      n++;
    }
    return new int[]{m + 1, n - 1};
  }

  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    searchRange(nums, 8);

  }

  /**
   * 方法太过巧妙，应该时长复习一下对于low和high还有条件判断的东西，真的是太巧妙了
   * @param nums
   * @param target
   * @return
   */
  public static int[] searchRange(int[] nums, int target) {
    int[] result = {-1,-1};
    int left = binarySearch(nums, target, true);
    if ( left == nums.length||nums[left] != target) {
      return result;
    }
    int right = binarySearch(nums, target, false);
    return new int[]{left, right-1};
  }

  public static int binarySearch(int[] nums, int target, boolean isLeft) {
    int low = 0, high = nums.length;
    while (low < high) {
      int mid = (low + high) / 2;
      if (nums[mid] > target || (nums[mid] == target && isLeft)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
