package com.fullofinspiration.github.leetcode;


import java.util.ArrayList;
import java.util.List;

public class _0207_Course {
    /**
     * 开始时间：9：12
     * 结束时间：11：00
     * 共1:50
     * 超时了,需要增加已访问节点记录，防止重复计算：https://leetcode.cn/problems/course-schedule/solutions/18806/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa
     */
    class Solution {
        private int[] flags;
        private List<List<Integer>> edges = new ArrayList<>();


        public boolean canFinish(int numCourses, int[][] prerequisites) {
            flags = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < prerequisites.length; i++) {
                int[] edge = prerequisites[i];
                int idx = edge[1];
                edges.get(idx).add(edge[0]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (edges.get(i).isEmpty()) {
                    continue;
                }
                boolean qualified = backtrace(i);
                if (!qualified) {
                    return false;
                }
            }
            return true;
        }

        private boolean backtrace(int idx) {
            if (flags[idx] == 1) {
                return false;
            }
            if (flags[idx] == -1) {
                return true;
            }
            List<Integer> curEdges = edges.get(idx);
            if (curEdges == null) {
                return true;
            }
            flags[idx] = 1;
            for (int nextIdx : curEdges) {
                boolean success = backtrace(nextIdx);
                if (!success) {
                    return false;
                }
            }
            flags[idx] = -1;
            return true;
        }
    }
}
