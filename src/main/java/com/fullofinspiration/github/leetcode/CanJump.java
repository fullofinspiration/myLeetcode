package com.fullofinspiration.github.leetcode;


public class CanJump {

  enum Index {GOOD, BAD, UNKNOWN}

  public boolean canJump(int[] nums) {
    Index[] indexs = new Index[nums.length];
    for (int i = 0; i < indexs.length; i++) {
      indexs[i] = Index.UNKNOWN;
    }
    indexs[nums.length - 1] = Index.GOOD;
    for (int i = nums.length - 2; i >= 0; i--) {
      int maxIndex = Math.min(i + nums[i], nums.length - 1);
      for (int j = maxIndex; j >= i; j--) {
        if (indexs[j] == Index.GOOD) {
          indexs[i] = Index.GOOD;
          break;
        }
      }
    }
    return indexs[0] == Index.GOOD;
  }
}
