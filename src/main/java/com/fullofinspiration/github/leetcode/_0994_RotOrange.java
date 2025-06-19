package com.fullofinspiration.github.leetcode;

import java.util.LinkedList;

public class _0994_RotOrange {
    /**
     * 开始时间11：43
     * 吃饭休息 1.5h
     * 结束时间:14:00
     * 广度优先搜索
     */
    class Solution {
        private int[][] grid;
        private LinkedList<int[]> rottedOranges = new LinkedList<>();
        private int notRotted = 0;

        public int orangesRotting(int[][] grid) {
            this.grid = grid;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        rottedOranges.addLast(new int[]{i, j});
                    }
                    if (grid[i][j] == 1) {
                        notRotted++;
                    }
                }
            }
            int count = rottedOranges.size();
            int minutes = 0;
            while (rottedOranges.size() > 0) {
                int[] curs = rottedOranges.removeFirst();
                int i = curs[0], j = curs[1];
                handleIdx(i - 1, j);
                handleIdx(i + 1, j);
                handleIdx(i, j - 1);
                handleIdx(i, j + 1);
                count--;
                if (count == 0 && rottedOranges.size() > 0) {
                    minutes++;
                    count = rottedOranges.size();
                }
            }
            if (notRotted > 0) {
                return -1;
            }
            return minutes;
        }

        private void handleIdx(int i, int j) {
            if (i < 0 || i >= grid.length) {
                return;
            }
            if (j < 0 || j >= grid[0].length) {
                return;
            }
            if (grid[i][j] == 1) {
                grid[i][j] = 2;
                rottedOranges.addLast(new int[]{i, j});
                notRotted--;
            }
        }
    }
}
