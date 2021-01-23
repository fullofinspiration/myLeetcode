package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public List<List<Integer>> fourSum(int[] num, int target) {
    if (num == null || num.length < 4) {
      return new ArrayList<>();
    }
    Arrays.sort(num);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < num.length - 3; i++) {
      for (int j = i + 1; j < num.length - 2; j++) {
        int m = j + 1, n = num.length - 1;
        while (m < n) {
          int curSum = num[i] + num[j] + num[m] + num[n];
          if (curSum == target) {
            result.add(Arrays.asList(num[i], num[j], num[m], num[n]));
            while (m + 1 < n && num[m + 1] == num[m]) {
              m++;
            }
            while (n - 1 > m && num[n - 1] == num[n]) {
              n--;
            }
            m++;
            n--;
          } else if (curSum > target) {
            n--;
          } else {
            m++;
          }
        }
        while (j + 1 < num.length - 2 && num[j + 1] == num[j]) {
          j++;
        }
      }
      while (i + 1 < num.length - 3 && num[i + 1] == num[i]) {
        i++;
      }
    }
    return result;
  }

}
