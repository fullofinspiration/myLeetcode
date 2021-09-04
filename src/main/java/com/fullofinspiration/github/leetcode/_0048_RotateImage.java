package com.fullofinspiration.github.leetcode;

/**
 * 按照斜线选择第一个元素来作为一次循环起点
 * 程序逻辑：
 * 按照上， 右，下，左，分别把数据放在对应行上
 */
public class _0048_RotateImage {
    class Solution {
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
