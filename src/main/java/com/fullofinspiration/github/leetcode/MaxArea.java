package com.fullofinspiration.github.leetcode;

public class MaxArea {
  public static int maxArea(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }
    int length = height.length,curMaxSize = 0;
    int prev = 0,after = length - 1;
    while ((prev < after)) {
       curMaxSize = Math.max(curMaxSize,(after-prev) * Math.min(height[prev],height[after]));
      if (height[prev] > height[after]) {
        after--;
      } else {
        prev++;
      }
    }
    return curMaxSize;
  }
}
