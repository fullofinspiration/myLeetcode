package com.fullofinspiration.github.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class _0763_PartitionLabels {
    /**
     * https://leetcode.com/problems/partition-labels/solutions/1868842/java-c-visually-explaineddddd/?orderBy=most_votes
     * 1 存储最后出现的节点
     * 2 prev=-1, 如果cur==farthest, 增加间隔数量
     */
    class Solution {
        public List<Integer> partitionLabels(String s) {
            Map<Character, Integer> char2Idx = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char2Idx.put(s.charAt(i), i);
            }
            int prev = -1;
            int min = 0;
            List<Integer> rst = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                Integer idx = char2Idx.get(s.charAt(i));
                min = Math.max(min, idx);
                if (i == min) {
                    rst.add(i - prev);
                    prev = i;
                }
            }
            return rst;
        }
    }

    /**
     * 1 idx 存储在数组中 避免初始化，索引从1 开始
     * 2 每次查找，若不存在，则插入当前索引到栈中&插入数据到数组中
     */
    class Solution01 {
        public List<Integer> partitionLabels(String s) {
            if (s.length() == 0) {
                return Collections.emptyList();
            }
            int[] earliestIdx = new int[26];
            // 右闭区间
            Stack<Integer> allIntervals = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (earliestIdx[idx] == 0) {
                    allIntervals.push(i);
                    earliestIdx[idx] = i + 1;
                    continue;
                }
                while (!allIntervals.isEmpty()) {
                    if (allIntervals.peek() >= earliestIdx[idx] - 1) {
                        allIntervals.pop();
                    }
                }
                allIntervals.push(i);
            }
            List<Integer> all = new ArrayList<>();
            int lastIdx = allIntervals.pop();
            while (!allIntervals.isEmpty()) {
                int pop = allIntervals.pop();
                all.add(lastIdx - pop);
                if (allIntervals.isEmpty()) {
                    all.add(pop + 1);
                }
            }
            Collections.reverse(all);
            return all;
        }
    }

    /**
     * 1 存储一个数组0-26，value是int[], 0是最低索引，1 是最高索引
     * 2 有交叉则合并,合并间隔按照索引排序
     * 3 定制返回值
     */
    class Solution00 {
        public List<Integer> partitionLabels(String s) {
            int[] lowIdx = new int[26];
            int[] highIdx = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (lowIdx[idx] == 0) {
                    lowIdx[idx] = i + 1;
                }
                highIdx[idx] = i + 1;
            }
            List<Integer> all = new ArrayList<>();
//            for (int i = 0; i < 26; i++) {
//                if (lowIdx[i] > )
//            }
            return null;
        }
    }
}
