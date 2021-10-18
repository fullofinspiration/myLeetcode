package com.fullofinspiration.github.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class _200_NumberOfLands {
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

        public int numIslands(char[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            visited = new boolean[grid.length][grid[0].length];
            int nums = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '0' || visited[i][j]) {
                        continue;
                    }
                    traverse(i, j, grid);
                    nums++;
                }
            }
            return nums;
        }

        private void traverse(int row, int col, char[][] grid) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return;
            }
            if (visited[row][col]) {
                return;
            }
            if (grid[row][col] == '0') {
                return;
            }
            visited[row][col] = true;
            traverse(row - 1, col, grid);
            traverse(row + 1, col, grid);
            traverse(row, col - 1, grid);
            traverse(row, col + 1, grid);
        }
    }

    class Solution1 {
        private Set<Key> visitedKeys = new HashSet<>();

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int sum = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == '0') {
                        continue;
                    }
                    if (visitedKeys.contains(new Key(row, col))) {
                        continue;
                    }
                    sum++;
                    markAsVisited(grid, row, col);
                }
            }
            return sum;
        }

        private void markAsVisited(char[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                return;
            }
            if (grid[row][col] == '0') {
                return;
            }

            Key key = new Key(row, col);
            if (visitedKeys.contains(key)) {
                return;
            }
            visitedKeys.add(key);
            markAsVisited(grid, row, col - 1);
            markAsVisited(grid, row - 1, col);
            markAsVisited(grid, row + 1, col);
            markAsVisited(grid, row, col + 1);
        }

        private class Key {
            private final int row;
            private final int col;

            public Key(int row, int col) {
                this.row = row;
                this.col = col;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Key key = (Key) o;
                return row == key.row && col == key.col;
            }

            @Override
            public int hashCode() {
                return Objects.hash(row, col);
            }
        }
    }
}
