package com.fullofinspiration.github.leetcode;

/**
 * todo 第二次看时看不懂问题，后面再看
 */
public class _0031_NextPermutation {

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
