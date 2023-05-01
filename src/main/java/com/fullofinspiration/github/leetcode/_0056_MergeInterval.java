package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class _0056_MergeInterval {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return intervals;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<int[]> all = new ArrayList<>();
            int[] cur = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] > cur[1]) {
                    all.add(cur);
                    cur = intervals[i];
                    continue;
                }
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
            all.add(cur);
            return all.toArray(new int[all.size()][2]);
        }
    }

    /**
     * 看样子这个数组像是递增排序的
     * 1 新建数组，长度为旧的数组长度
     * 2 取出老数组的第一个元素
     * 3 从老数组第二个元素开始，和取出的元素比较：
     * if (high4Added>= LowInArr):
     * high4Added = highInArr;
     * index++;
     * else:
     * 将该值放到result中
     * 老数组中元素取出作为即将插入元素
     */
    class Solution00 {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return new int[][]{};
            }
            Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
            List<int[]> all = new ArrayList<>();
            int curIndex = 0;
            while (curIndex < intervals.length) {
                int highIndex = curIndex;
                int curMaxValue = intervals[curIndex][1];
                while (highIndex + 1 < intervals.length && curMaxValue >= intervals[highIndex + 1][0]) {
                    highIndex++;
                    curMaxValue = Math.max(curMaxValue, intervals[highIndex][1]);
                }
                int[] ints = {intervals[curIndex][0], curMaxValue};
                all.add(ints);
                curIndex = highIndex + 1;
            }
            return all.toArray(new int[][]{});
        }
    }
}
