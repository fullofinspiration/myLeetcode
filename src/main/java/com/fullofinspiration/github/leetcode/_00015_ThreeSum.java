package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _00015_ThreeSum {

  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
    System.out.println(threeSum(nums));
  }

  /**
   * 太他娘的繁琐了.
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return new ArrayList<>();
    }
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length-2; i++) {
      if (i != 0 && nums[i] == nums[i-1]) {
        continue;
      }
      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        int curSum = nums[i] + nums[j] + nums[k];
        if (curSum > 0) {
          k--;
        } else if (curSum == 0) {
           result.add(Arrays.asList(nums[i],nums[j],nums[k]));
          while (j < k && nums[j+1] == nums[j]) {
            j++;
          }
          while (j < k && nums[k-1] == nums[k]) {
            k--;
          }
          j++;
          k--;

        } else {
          j++;
        }
      }
    }
    return result;
  }
}
