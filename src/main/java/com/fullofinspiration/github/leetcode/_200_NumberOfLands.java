package com.fullofinspiration.github.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class _200_NumberOfLands {
    class Solution {
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
