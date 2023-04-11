package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0078_SubSets {
    /**
     * 回溯，每次增加到结果中
     * 错误
     * 1： 初始idx是-1
     * 2:  结果应该放在new ArrayList中
     *
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums.length == 0) {
                return Collections.emptyList();
            }
            List<List<Integer>> all = new ArrayList<>();
            backtrack(all, nums, new ArrayList<>(), -1);
            return all;
        }

        private void backtrack(List<List<Integer>> all, int[] nums, List<Integer> cur, int idx) {
            all.add(new ArrayList<>(cur));
            for (int i = idx+1; i < nums.length; i++) {
                cur.add(nums[i]);
                backtrack(all, nums, cur, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /**
     * 对于每个长度，都调用一次该函数，最终求得所有的值
     * 对于长度为length的datas[], 求长度为length4SubSet所有子数组函数:
     * def List<List<String>> getSubSet(datas[]) {
     * <p>
     * }
     * maxVal = 数组中最大值
     * map<Integer, Integer> val2Index 值对应的索引
     * def List<List<String>> getSubSet(int targetLength):
     * List<List<String>> allValues = new ArrayList<>();
     * for(int curLength=0; curLength < targetLength; curLength++):
     * for(List<Integer> value: allValues):
     * //每次增加的值都会放入到该数组中，这里作为遍历终止的条件
     * if (value.size() > curLength)
     * break;
     * for(int index = val2Index.get(value.get(value.size()-1))+1; index < data.length; index++):
     * value.add(array[index]);
     * allValues.add(value);
     */
    class Solution00 {
        private final List<List<Integer>> all = new ArrayList<>();

        private Map<Integer, Integer> value2Index = new HashMap<>();

        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null) {
                all.add(Collections.emptyList());
                return all;
            }
            for (int i = 0; i < nums.length; i++) {
                value2Index.put(nums[i], i);
            }
            for (int i = 0; i <= nums.length; i++) {
                addSubSets(nums, new ArrayList<>(), i);
            }
            return all;
        }

        private void addSubSets(int[] nums, List<Integer> partial, int targetLength) {
            if (partial.size() == targetLength) {
                all.add(partial);
                return;
            }
            int curMaxIndex = -1;
            if (!partial.isEmpty()) {
                Integer value = partial.get(partial.size() - 1);
                curMaxIndex = value2Index.get(value);
                if (curMaxIndex >= nums.length) {
                    return;
                }
            }

            for (int i = curMaxIndex + 1; i < nums.length; i++) {
                ArrayList<Integer> integers = new ArrayList<>(partial);
                integers.add(nums[i]);
                addSubSets(nums, integers, targetLength);
            }
        }
    }
}
