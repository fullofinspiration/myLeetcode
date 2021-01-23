package com.fullofinspiration.github.leetcode;

public class RemoveElement {
  public int removeElement(int[] num,int val) {
    if (num == null ||num.length == 0) {
      return 0;
    }
    int curPreIndex =0;
    for (int i = 0;i < num.length;i++) {
      if (num[i] != val) {
        num[curPreIndex] = num[i];
        curPreIndex++;
      }
    }
    return curPreIndex;
  }
}
