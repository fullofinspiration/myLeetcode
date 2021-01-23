package com.fullofinspiration.github.leetcode;

public class SearchInsert {

  /**
   *一把过，但是第一次遇到这么脑残的问题
   * @param nums
   * @param target
   * @return
   */
  public int searchInsert(int[] nums, int target) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] >= target) {
        break;
      }
      i++;
    }
    return i;
  }

}
