package com.fullofinspiration.github.leetcode;

public class _0695_MaxAreaOfLands {
    /**
     * 新建一个数组，设置每个节点是否被访问过
     * 一个总数量标记当前岛屿数量
     * 从左到右 从上到下:
     * 若一个节点为0，遍历下一个节点
     * 若一个节点访问过，遍历下一个节点
     * 已当前节点为中心，上下左右，穷举所有能直接访问的1的节点，然后将总数加1
     * 穷举过程：
     * 递归的方式，上下左右（必须上下左右，否则有可能漏掉值）
     */
    class Solution {
        boolean[][] visited;

        public int maxAreaOfIsland(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            visited = new boolean[grid.length][grid[0].length];
            int maxCount = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0 || visited[i][j]) {
                        continue;
                    }
                    int count = getCount(i, j, grid);
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }
            }
            return maxCount;
        }

        private int getCount(int row, int col, int[][] grid) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return 0;
            }
            if (visited[row][col]) {
                return 0;
            }
            if (grid[row][col] == 0) {
                return 0;
            }
            visited[row][col] = true;
            int left = getCount(row - 1, col, grid);
            int right = getCount(row + 1, col, grid);
            int up = getCount(row, col - 1, grid);
            int down = getCount(row, col + 1, grid);
            return 1 + left + right + up + down;
        }
    }
}
