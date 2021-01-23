package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

  /**
   * 我不知道原理，只是照抄过来的，估计过两天就忘记了
   * @param candidates
   * @param target
   * @return
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(list, new ArrayList<>(), candidates, target, 0);
    return list;
  }

  public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] num,
      int remain,
      int start) {
    if (remain == 0) {
      list.add(new ArrayList<>(tempList));
      return;
    }
    if (remain < 0) {
      return;
    }
    for (int i = start; i < num.length; i++) {
      if (i > start && num[i] == num[i-1]) {
        continue;
      }
      tempList.add(num[i]);
      backtrack(list, tempList, num, remain - num[i], i + 1);
      tempList.remove(tempList.size() - 1);
    }
  }
}
