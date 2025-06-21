package com.fullofinspiration.github.leetcode;

public class _0240_BinarySearchMatrix {

    /**
     * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
     */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }
            int i = matrix.length - 1, j = 0;
            while (i >= 0 && j <= matrix[0].length - 1) {
                int cur = matrix[i][j];
                if (cur > target) {
                    i--;
                } else if (cur < target) {
                    j++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    class WrongSolution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix[0].length == 0) {
                return false;
            }
            int low = 0, high = matrix.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[mid][0] > target) {
                    high = mid - 1;
                } else if (matrix[mid][0] == target) {
                    return true;
                } else {
                    if (matrix[mid][matrix[0].length - 1] > target) {
                        low = mid;
                        break;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            int row = low;
            low = 0;
            high = matrix[0].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (matrix[row][mid] < target) {
                    low = mid + 1;
                } else if (matrix[row][mid] == target) {
                    return true;
                } else {
                    high = mid - 1;
                }
            }
            return false;
        }
    }
}
