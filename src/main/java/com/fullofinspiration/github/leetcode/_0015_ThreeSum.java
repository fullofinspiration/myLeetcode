package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0015_ThreeSum {
    /**
     * 双指针标准写法：https://leetcode.cn/problems/3sum/solutions/284681/san-shu-zhi-he-by-leetcode-solution
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);
            List<List<Integer>> rets = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                while (i > 0 && i < nums.length - 1 && nums[i] == nums[i - 1]) {
                    i++;
                }
                int target = -nums[i];
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int curSum = nums[l] + nums[r];
                    if (curSum == target) {
                        rets.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (curSum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return rets;
        }
    }

    /**
     * 结果用set去重
     * 手误写成i++，应该是j++
     */
    class Solution01 {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> rst = new HashSet<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        rst.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            return new ArrayList<>(rst);
        }
    }

    /**
     * 时间复杂度O(n),排序O(nLogN) 总时间复杂度O(nLogN)
     * 空间复杂度O(n)
     * 1 排序
     * 2 从左到右，从又到左
     * 3 缓存到一个map中
     * 该方法会导致遗漏掉一些结果
     */
    class WrongSolution01 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> all = new ArrayList<>();
            Map<Integer, Set<Integer>> value2Idx = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (value2Idx.containsKey(nums[i])) {
                    value2Idx.get(nums[i]).add(i);
                } else {
                    HashSet<Integer> idxs = new HashSet<>();
                    idxs.add(i);
                    value2Idx.put(nums[i], idxs);
                }
            }
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int target = -nums[i] - nums[j];
                if (value2Idx.containsKey(target)) {
                    for (int idx : value2Idx.get(target)) {
                        if (idx > i && idx < j) {
                            List<Integer> idxs = new ArrayList<>();
                            idxs.add(nums[i]);
                            idxs.add(nums[idx]);
                            idxs.add(nums[j]);
                            all.add(idxs);
                        }
                    }
                }
                while (nums[i + 1] == nums[i]) {
                    i++;
                }
                while (nums[j - 1] == nums[j]) {
                    j--;
                }
                i++;
                j--;
            }
            return all;
        }
    }

    /**
     * 时间复杂度O(n^2) 空间复杂度O(n)
     * 错误1： 保存结果报错错了，保存的是索引，实际应该是值
     * 错误2： j应该从i+1开始，否则会有重复值
     * 错误3： 应该是curIDX>j不应该是value>j 这里由于变量明明模糊导致的错误
     * 错误4： 审题错误，如果有重复值应该跳过 如果通过class去重，会很臃肿，放弃该方法
     */
    class WrongSolution00 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> all = new ArrayList<>();
            Map<Integer, Set<Integer>> value2Idx = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (value2Idx.containsKey(nums[i])) {
                    value2Idx.get(nums[i]).add(i);
                } else {
                    HashSet<Integer> idxs = new HashSet<>();
                    idxs.add(i);
                    value2Idx.put(nums[i], idxs);
                }
            }
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int value = -nums[i] - nums[j];
                    if (!value2Idx.containsKey(value)) {
                        continue;
                    }
                    for (int curIdx : value2Idx.get(value)) {
                        if (curIdx > j) {
                            ArrayList<Integer> rst = new ArrayList<>();
                            rst.add(nums[i]);
                            rst.add(nums[j]);
                            rst.add(nums[curIdx]);
                            all.add(rst);
                        }
                    }
                }
            }
            return all;
        }
    }

    class Solution00 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> all = new ArrayList<>();
            //可以直接写Arrays.sort
            //Arrays.sort(nums);
            quickSort(nums, 0, nums.length - 1);
            for (int left = 0; left < nums.length; left++) {
                if (left > 0 && nums[left] == nums[left - 1]) {
                    continue;
                }
                int mid = left + 1;
                int right = nums.length - 1;
                while (mid < right) {
                    int curSum = nums[left] + nums[mid] + nums[right];
                    if (curSum == 0) {
                        List<Integer> results = Arrays.asList(nums[left], nums[mid], nums[right]);
                        all.add(results);
                        mid++;
                        right--;
                        while (mid < right && nums[mid] == nums[left]) {
                            mid++;
                        }
                        while (mid < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                    } else if (curSum < 0) {
                        mid++;
                    } else {
                        right--;
                    }
                }
            }
            return all;
        }

        private void quickSort(int[] nums, int low, int high) {
            if (low >= high) {
                return;
            }
            int left = low;
            int right = high;
            int curVal = nums[left];
            while (left < right) {
                while (nums[right] >= curVal && right > left) {
                    right--;
                }
                nums[left] = nums[right];
                while (nums[left] <= curVal && left < right) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = curVal;
            quickSort(nums, low, left - 1);
            quickSort(nums, left + 1, high);
        }

    }

    /**
     * 太他娘的繁琐了.
     */
    public static List<List<Integer>> threeSum01(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int curSum = nums[i] + nums[j] + nums[k];
                if (curSum > 0) {
                    k--;
                } else if (curSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
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
