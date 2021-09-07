package com.fullofinspiration.github.leetcode;

/**
 * 要想得到每个节点的最小路径的和，类似于分而治之的思想
 * 每个节点都是只有向下和向右，所以对于某个节点，取正上方和正左方较小的值，即可得到到达当前节点路径最小的和
 * 从第一行开始遍历，然后遍历第二行，第三行，每个节点取正上方和正左方较小的值，然后加上当前节点的值，作为结果
 * 时间复杂度O(n) 空间复杂度O(n)
 */
public class _0064_MinimumPathSum {
    class Solution {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid[0].length == 0) {
                return 0;
            }
            int row = grid.length;
            int col = grid[0].length;
            int[][] minPathSums = new int[row + 1][col + 1];
            for (int j = 2; j <= col; j++) {
                minPathSums[0][j] = Integer.MAX_VALUE;
            }
            for (int i = 2; i <= row; i++) {
                minPathSums[i][0] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    minPathSums[i + 1][j + 1] = Math.min(minPathSums[i + 1][j], minPathSums[i][j + 1]) + grid[i][j];
                }
            }
            return minPathSums[row][col];
        }
    }
}
