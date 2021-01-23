package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    int[] candidates = {2, 3, 6, 7};
    System.out.println(combinationSum(candidates, 7));
  }

  /**
   * 我画了一张图，我觉得很有帮助，这道题是抄的，但是我以后尽量能自己写出来
   */
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidate,
      int remain, int index) {
    if (remain < 0) {
      return;
    }
    if (remain == 0) {
      result.add(new ArrayList<>(tempList));
      return;
    }
    for (int i = index; i < candidate.length; i++) {
      tempList.add(candidate[i]);
      backtrack(result, tempList, candidate, remain - candidate[i], i);
      tempList.remove(tempList.size() - 1);
    }
  }
}
