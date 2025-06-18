package com.fullofinspiration.github.leetcode;

public class _0074_Search2DMatrix {
    /**
     * 索引映射到二维数组上，因为整体是有序的
     */
    class Solution {
        int m, n;
        int[][] matrix;

        public boolean searchMatrix(int[][] matrix, int target) {
            m = matrix.length;
            n = matrix[0].length;
            this.matrix = matrix;
            int low = 0, high = m * n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int midVal = getVal(mid);
                if (midVal == target) {
                    return true;
                }
                if (midVal > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }

        private int getVal(int idx) {
            int row = idx / n;
            int col = idx % n;
            return matrix[row][col];
        }
    }

    class Solution01 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int low = 0, high = matrix.length - 1;
            while (low < high) {
                int lowVal = matrix[low][0];
                int mid = (low + high + 1) / 2;
                int midVal = matrix[mid][0];
                if (target < lowVal) {
                    return false;
                }
                if (midVal == target) {
                    return true;
                }
                if (midVal > target) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
            if (low != high) {
                throw new IllegalStateException();
            }

            int row = low;
            low = 0;
            high = matrix[0].length - 1;
            while (low <= high) {
                int lowVal = matrix[row][low];
                int highVal = matrix[row][high];
                int mid = (low + high) / 2;
                int midVal = matrix[row][mid];
                if (lowVal > target || highVal < target) {
                    return false;
                }
                if (midVal == target) {
                    return true;
                }
                if (midVal < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return false;
        }
    }

    class Solution00 {
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
