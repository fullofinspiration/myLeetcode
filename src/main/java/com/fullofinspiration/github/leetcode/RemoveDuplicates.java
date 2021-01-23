package com.fullofinspiration.github.leetcode;

public class RemoveDuplicates {
  //一把过，我真是太牛逼了
  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length <=1) {
      return nums.length;
    }
    int curIndex = 0;
    for (int i=1;i < nums.length;i++) {
      if (nums[i] > nums[curIndex]) {
        nums[++ curIndex] =nums[i];
      }
    }
    return curIndex+1;
  }
}
