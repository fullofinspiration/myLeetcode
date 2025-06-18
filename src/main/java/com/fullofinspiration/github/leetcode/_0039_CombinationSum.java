package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0039_CombinationSum {
    /**
     * 开始时间: 22:31
     * 结束时间: 22:41
     *
     */
    class Solution {
        List<List<Integer>> rets = new ArrayList<>();
        ArrayList<Integer> parRet = new ArrayList<>();
        int[] candidates;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            backtrace(0, target);
            return rets;
        }

        private void backtrace(int idx, int target) {
            if (target == 0) {
                rets.add(new ArrayList<>(parRet));
                return;
            }
            if (target < 0) {
                return;
            }
            for (int i = idx; i < candidates.length; i++) {
                int cur = candidates[i];
                parRet.add(cur);
                backtrace(i, target - cur);
                parRet.remove(parRet.size() - 1);
            }
        }
    }

    /**
     * 开始时间: 21:29
     * 结束时间: 22:31
     * 判断条件太复杂，还原成之前写法
     */
    class Solution02 {
        List<List<Integer>> rets = new ArrayList<>();
        LinkedList<Integer> parRet = new LinkedList<>();
        int[] candidates;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            backtrace(0, target);
            return rets;
        }

        private void backtrace(int idx, int target) {
            if (target == 0) {
                rets.add(new ArrayList<>(parRet));
                return;
            }
            if (target < 0) {
                return;
            }
            if (idx > candidates.length - 1) {
                return;
            }
            backtrace(idx + 1, target);

            int cur = candidates[idx];
            int count = 0;
            while (target - count > 0) {
                parRet.add(cur);
                count += cur;
                backtrace(idx + 1, target - count);
            }
            count /= cur;
            while (count-- > 0) {
                parRet.removeLast();
            }
        }
    }

    /**
     * 暴力法，使用递归的方式
     * 1：每次看是否等于当前值，如果是，则返回，否则遍历其他
     */
    class Solution01 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> all = new ArrayList<>();
            traverse(all, candidates, new ArrayList<>(), target, 0);
            return all;
        }

        private void traverse(List<List<Integer>> all, int[] candidates, ArrayList<Integer> tempList, int remain, int idx) {
            if (remain < 0) {
                return;
            }
            if (remain == 0) {
                all.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = idx; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                traverse(all, candidates, tempList, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    /**
     * 初步想法：回溯法，结果中值是升序排列，
     * 在求值程中，每个结果值是升序排列的,比如(2,3,5)，结果值是8，如果结果是(3,($1),...), $1 >=3 , 不能为2，通过这样来保证终止条件
     */
    class Solution00 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return Collections.emptyList();
            }
            Map<Integer, Integer> value2Index = new HashMap<>();
            for (int i = 0; i < candidates.length; i++) {
                value2Index.put(candidates[i], i);
            }
            List<List<Integer>> all = new ArrayList<>();
            LinkedList<List<Integer>> temp = new LinkedList<>();
            for (int num : candidates) {
                ArrayList<Integer> curValues = new ArrayList<>();
                curValues.add(num);
                temp.add(curValues);
            }
            while (!temp.isEmpty()) {
                List<Integer> integers = temp.removeLast();
                int sum = integers.stream().mapToInt(Integer::intValue).sum();
                if (sum == target) {
                    all.add(integers);
                } else if (sum > target || integers.size() >= 150) {
                    continue;
                }
                for (int i = value2Index.get(integers.get(integers.size() - 1)); i < candidates.length; i++) {
                    ArrayList<Integer> newValues = new ArrayList<>(integers);
                    newValues.add(candidates[i]);
                    temp.add(newValues);
                }
            }
            return all;
        }

    }

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
