package com.fullofinspiration.github.leetcode;

public class _0074_Search2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }
            if (matrix[0].length == 0) {
                return false;
            }
            int rowLength = matrix.length;
            int colLength = matrix[0].length;

            int i = rowLength - 1, j = 0;
            while (i >= 0 && j < colLength) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    i--;
                    continue;
                }
                j++;
            }
            return false;
        }
    }
}
