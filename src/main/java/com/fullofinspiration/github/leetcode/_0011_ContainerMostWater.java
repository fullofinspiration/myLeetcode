package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 看如何能盛下最多的水 我是参考了hint中才实现的，原来写的时间复杂度是O(n^2),参考的这篇时间复杂度是O(n)
 */
public class _0011_ContainerMostWater {

  class Solution {
    public int maxArea(int[] height) {
      int max = Integer.MIN_VALUE;
      int low = 0;
      int high = height.length-1;
      while (low < high) {
        max = Math.max(max, Math.min(height[low],height[high]) * (high-low));
        if (height[low] < high) {
          low ++ ;
        }
         else {
           high--;
        }
      }
      return max;
    }
  }
  /**
   * 没有写完，这种方式太复杂了，而且没有必要
   */
  class Solution1 {
    public int maxArea(int[] height) {
      if (height == null || height.length == 0) {
        return 0;
      }
      Map<Integer, Boolean> visited = new HashMap<>();
      for (int i = 0; i < height.length; i++) {
        visited.put(i, false);
      }
      int low = 0;
      int high = height.length - 1;
      visited.put(low, true);
      visited.put(high, true);
      int max = calcArea(height, low, high);
      while (low < high) {
        int leftMax = calcArea(height, low + 1, high);
        int rightMax = calcArea(height, low, low + 1);
        if (leftMax >= rightMax) {
          visited.put(low, true);
          low++;
        } else {
          visited.put(high, true);
          high = low + 1;
        }
        return -1;
      }
      return -1;
    }

    private int calcArea(int[] height, int left, int right) {
      return (right - left) * Math.min(height[left], height[right]);
    }
  }

  public int maxArea(int[] height) {
    int maxValue = 0;
    int i = 0, j = height.length - 1;
    while (i < j) {
      maxValue = Math.max(maxValue, Math.min(height[i], height[j]) * (j - i));
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return maxValue;
  }

}
