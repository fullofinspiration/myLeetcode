package com.fullofinspiration.github.leetcode;

import java.util.Arrays;

public class ThreeSumCloset {

  /**
   * 值得纪念的时刻，这把写的代码一把过！！！！！！！！！！！
   * @param args
   */
  public static void main(String[] args) {
    int[] array = {-1,2,1,-4};
    int i = threeSumClosest(array, 1);
    System.out.println(i);
  }
  public static int threeSumClosest(int[] num, int target) {
    if (num == null || num.length < 3) {
      return 0;
    }
    Arrays.sort(num);
    int closet = num[0] + num[1] + num[2];
    for (int i = 0; i < num.length - 2; i++) {
      int j = i + 1, k = num.length - 1;
      while (j < k) {
        int curSum = num[i] + num[j] + num[k];
        if (Math.abs(curSum - target) < Math.abs(closet - target)) {
          closet  = curSum;
        }
        if (curSum > target) {
          k--;
        }
        if (curSum < target) {
          j++;
        }
        if (curSum == target) {
          return target;
        }
      }
    }
    return closet;
  }
}
