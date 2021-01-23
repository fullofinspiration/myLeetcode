package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    System.out.println(permute(nums));
  }

  public  static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> allList = new ArrayList<>();
    backtrack(allList, new ArrayList<>(), nums);
    return allList;
  }

  /**
   * 这是标准答案，它比我写的更精简，在加入时候就进行判断是否有重复元素，而不是在进入递归时再判断
   * @param allList
   * @param list
   * @param nums
   */
  public static void backtrack(List<List<Integer>> allList, List<Integer> list, int[] nums) {
    if (list.size() == nums.length) {
      allList.add(new ArrayList<>(list));
      return;
    } else {
      for (int i=0;i < nums.length;i++) {
        if (list.contains(nums[i])) {
          continue;
        }
        list.add(nums[i]);
        backtrack(allList,list,nums);
        list.remove(list.size()-1);
      }
    }
  }

  /**
   * 这个思路是我完全自己思考出来的，没有看答案，
   * 但是思路是参考列举出数组中所有的和是某个值的list： https://leetcode.com/problems/combination-sum/
   * @param nums
   * @return
   */
  public static void backtrack1(List<List<Integer>> allList, LinkedList<Integer> list, int[] nums) {
    if (list.size() > 0 && list.indexOf(list.getLast()) != list.size() - 1) {
      return;
    }
    if (list.size() == nums.length) {
      allList.add(new LinkedList<>(list));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      list.add(nums[i]);
      backtrack(allList, list, nums);
      list.remove(list.size()-1);
    }
  }
}
