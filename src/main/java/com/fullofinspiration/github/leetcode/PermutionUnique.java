package com.fullofinspiration.github.leetcode;

import java.util.*;

public class PermutionUnique {

  public static void main(String[] args) {
    int[] nums = {1, 1, 2};
    System.out.println(permuteUnique(nums));
  }

  public static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
  }

  /**
   * 这里巧妙的地方在于判断条件，我的解法加上countMap和curCountMap
   * 对于新加进来的辅助是对所有的都有用的，我也没有具体区分，写的特别繁琐，实际面试中是肯定写不出来的
   * 但是这个方法中的条件解法非常好，它通过利用一个条件来判断对于相同的数值，只有第一个开头的有效，对于重复的
   * 值，只有前面那个值存在时，这个值才有必要存在，否则的话如果只有这个值，先前的值不存在的话，那么就略过这个
   * 值，这样可以有效的防止重复的结果。当然还有一般性的条件，它引入的used数组可以判断当前值是否使用过，这个基本功
   * 我还没有掌握，而且这个used数组相当于当前每个递归中只独享这个变量数组，非常有效。
   * @param list
   * @param tempList
   * @param nums
   * @param used
   */
  private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums,
      boolean[] used) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (used[i] || (i > 0 && nums[i] == nums[i-1]) && !used[i-1]) {
          continue;
        }
        used[i] = true;
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, used);
        tempList.remove(tempList.size() - 1);
        used[i] = false;
      }
    }
  }

  public static List<List<Integer>> permuteUnique1(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
      int count = countMap.containsKey(num) ? countMap.get(num) + 1 : 1;
      countMap.put(num, count);
    }
    backtrack1(list, new ArrayList<>(), nums, countMap, new HashMap<>());
    return list;
  }

  public static void backtrack1(List<List<Integer>> list, List<Integer> tempList, int[] nums,
      Map<Integer, Integer> countMap, Map<Integer, Integer> tempCountMap) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (i> 0 && nums[i] == nums[i-1]) {
          continue;
        }
        if (!tempCountMap.containsKey(nums[i]) || (tempCountMap.containsKey(nums[i])
            && tempCountMap.get(nums[i]) < countMap
            .get(nums[i]))) {
          int count = tempCountMap.containsKey(nums[i]) ? tempCountMap.get(nums[i]) : 0;
          tempCountMap.put(nums[i], count + 1);
          tempList.add(nums[i]);
          backtrack1(list, tempList, nums, countMap, tempCountMap);
          tempCountMap.put(nums[i], count);
          tempList.remove(tempList.size() - 1);
        }
      }
    }
  }
}
