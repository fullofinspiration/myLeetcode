package com.fullofinspiration.github.interview;

public class _0334_IncreasingTripletSubsequence {
  /**
   * https://leetcode.com/problems/increasing-triplet-subsequence/solutions/79002/simple-java-solution-easy-to-understand/?orderBy=most_votes
   */
  class Solution {
    public boolean increasingTriplet(int[] nums) {
      int low = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
      for (int num : nums) {
        if (num <= low) {
          low = num;
        } else if (num <= mid) {
          mid = num;
        } else {
          return true;
        }
      }
      return false;
    }
  }
}
