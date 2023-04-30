package com.fullofinspiration.github.leetcode;

public class _0048_RotateImage {
    /**
     * https://leetcode.com/problems/rotate-image/solutions/18872/a-common-method-to-rotate-the-image/comments/18970
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * 先上下转换
     * 7 8 9
     * 4 5 6
     * 1 2 3
     * 再对称转换
     * 7 4 1
     * 8 5 2
     * 9 6 3
     */
    class Solution {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int highRowIdx = matrix.length - 1 - i;
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[highRowIdx][j];
                    matrix[highRowIdx][j] = tmp;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[0].length; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }

    /**
     * 如何搬运我想不出来
     */
    class Solution01 {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = i; j < matrix.length - i; j++) {

                }
            }
        }
    }

    /**
     * 按照斜线选择第一个元素来作为一次循环起点
     * 程序逻辑：
     * 按照上， 右，下，左，分别把数据放在对应行上
     */
    class Solution00 {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int tmp = matrix[i][j];
                    int rowIndex4Higher = matrix.length - 1 - i;
                    matrix[i][j] = matrix[rowIndex4Higher][j];
                    matrix[rowIndex4Higher][j] = tmp;
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }
}
