package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0078_SubSets {
    /**
     * 开始时间: 7:00
     * 结束时间: 7:45
     * 吃饭20min
     */
    class Solution {
        List<List<Integer>> rets = new ArrayList<>();
        int[] nums;
        List<Integer> partRets = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            traceback(-1);

            return rets;
        }

        private void traceback(int idx) {
            rets.add(new ArrayList<>(partRets));
            for (int i = idx + 1; i < nums.length; i++) {
                partRets.add(nums[i]);
                traceback(i);
                partRets.remove(partRets.size() - 1);
            }
        }
    }

    /**
     * 放弃，总是出错
     */
    class Solution02 {
        List<List<Integer>> rets = new ArrayList<>();
        int[] nums;
        List<Integer> partRets = new ArrayList<>();
        boolean[] visited;

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            visited = new boolean[nums.length];
            rets.add(new ArrayList<>());
            traceback(0);

            return rets;
        }

        private void traceback(int idx) {
            rets.add(new ArrayList<>(partRets));
            if (idx >= nums.length) {
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                partRets.add(nums[i]);
                traceback(idx + 1);
                partRets.remove(partRets.size() - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * 回溯，每次增加到结果中
     * 错误
     * 1： 初始idx是-1
     * 2:  结果应该放在new ArrayList中
     */
    class Solution01 {
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
            for (int i = idx + 1; i < nums.length; i++) {
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
