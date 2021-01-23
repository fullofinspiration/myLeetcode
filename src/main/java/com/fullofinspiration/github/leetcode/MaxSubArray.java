package com.fullofinspiration.github.leetcode;

public class MaxSubArray {

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray2(nums));
  }

  public static int maxSubArray2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE, sum = 0;
    for (int num : nums) {
      if (sum < 0) {
        sum = num;
      } else {
        sum += num;
      }
      if (sum > max) {
        max = sum;
      }
    }
    return max;
  }

  /**
   * 我的答案，但是是错误的，实在不知该如何解决了
   */
  public static int maxSubArray1(int[] nums) {
    int gap = 0, curMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > 0) {
        if (nums[i] > curMax && gap + curMax < 0) {
          curMax = nums[i];
          gap = 0;
        } else if (curMax > nums[i]) {
          gap += nums[i];
        } else if ((nums[i] > curMax && gap + curMax > 0) || gap + nums[i] > 0) {
          curMax = curMax + gap + nums[i];
          gap = 0;
        } else {
          gap += nums[i];
        }
      } else {
        gap += nums[i];
      }
    }
    return curMax;
  }

  public static int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE, sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (sum < 0) {
        sum = nums[i];
      } else {
        sum += nums[i];
      }
      if (sum > max) {
        max = sum;
      }
    }
    return max;
  }
}
