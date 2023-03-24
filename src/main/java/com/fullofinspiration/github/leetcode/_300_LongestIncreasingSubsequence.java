package com.fullofinspiration.github.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO 有空再看O(nlogn)的解法：https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
 */
public class _300_LongestIncreasingSubsequence {
    /**
     * fn为包含当前值的最长元素 max为单独保存的结果 f(n)= max(f1,f2...fn-1) if array[n] > array[i]
     * 最后返回max
     */
    public class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] ints = new int[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int cur = 0;
                for (int j = 0; j <= i; j++) {
                    if (nums[j] < nums[i]) {
                        cur = Math.max(cur, ints[j]);
                    }
                }
                ints[i] = cur + 1;
                max = Math.max(max, ints[i]);
            }
            return max;
        }
    }

    /**
     * 当前解法: O(n^2)
     */
    public class Solution00 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] counts = new int[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int max4CurIndex = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && counts[j] > max4CurIndex) {
                        max4CurIndex = counts[j];
                    }
                }
                counts[i] = max4CurIndex + 1;
                if (counts[i] > max) {
                    max = counts[i];
                }
            }
            return max;
        }
    }

    //错误的解法
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            List<Data> datas = new LinkedList<>();
            Data curMaxData = new Data(nums[0], nums[0], 1);
            datas.add(curMaxData);
            for (int i = 1; i < nums.length; i++) {
                int curValue = nums[i];
                Iterator<Data> iterator = datas.iterator();
                while (iterator.hasNext()) {
                    Data curData = iterator.next();
                    if (curData.highValue < curValue) {
                        curData.length++;
                        curData.highValue = curValue;
                    }
                    if (curData.length > curMaxData.length) {
                        curMaxData = curData;
                    }
                    if (curData.length < curMaxData.length && curData.lowValue > curMaxData.lowValue) {
                        iterator.remove();
                    }
                }
                datas.add(new Data(curValue, curValue, 1));
            }
            return curMaxData.length;
        }

        private class Data {
            private final int lowValue;
            private int highValue;
            private int length;

            public Data(int lowValue, int highValue, int length) {
                this.lowValue = lowValue;
                this.highValue = highValue;
                this.length = length;
            }
        }
    }
}
