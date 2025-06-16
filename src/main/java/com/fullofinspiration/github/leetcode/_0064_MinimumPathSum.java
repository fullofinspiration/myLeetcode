package com.fullofinspiration.github.leetcode;


import java.util.Arrays;

public class _0064_MinimumPathSum {
    /**
     * 错了四五个位置
     */
    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] minSum = new int[grid.length + 1][grid[0].length + 1];
            for (int i = 0; i < minSum.length; i++) {
                minSum[i][0] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < minSum[0].length; j++) {
                minSum[0][j] = Integer.MAX_VALUE;
            }

            for (int i = 1; i < minSum.length; i++) {
                for (int j = 1; j < minSum[0].length; j++) {
                    if (i == 1 && j == 1) {
                        minSum[i][j] = grid[0][0];
                        continue;
                    }
                    minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i-1][j-1];
                }
            }
            return minSum[minSum.length - 1][minSum[0].length - 1];
        }
    }

    /**
     * 错误1：返回值应该是 minSum[grid.length ][grid[0].length] 而不是minSum[grid.length -1][grid[0].length]
     * 错误2：最左边应该是Integer.MaxValue，来保证第一次遍历成功
     * 错误3：系统 冷启动时，应该设置左上角数字是grid[i][j]
     * 可以优化的地方：确定起始点时，可以设置minSum[0][1=0]，这样就可以使走上角数字是正确的值
     */
    class Solution01 {
        public int minPathSum(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int[][] minSum = new int[grid.length + 1][grid[0].length + 1];
            for (int i = 2; i < minSum.length; i++) {
                minSum[i][0] = Integer.MAX_VALUE;
            }
            Arrays.fill(minSum[0], Integer.MAX_VALUE);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    minSum[i + 1][j + 1] = Math.min(minSum[i + 1][j], minSum[i][j + 1]) + grid[i][j];

                }
            }
            for (int[] a : minSum) {
                System.out.println(Arrays.toString(a));
            }
            return minSum[grid.length][grid[0].length];
        }
    }

    /**
     * 要想得到每个节点的最小路径的和，类似于分而治之的思想
     * 每个节点都是只有向下和向右，所以对于某个节点，取正上方和正左方较小的值，即可得到到达当前节点路径最小的和
     * 从第一行开始遍历，然后遍历第二行，第三行，每个节点取正上方和正左方较小的值，然后加上当前节点的值，作为结果
     * 时间复杂度O(n) 空间复杂度O(n)
     */
    class Solution00 {
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
