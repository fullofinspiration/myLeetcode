package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0048_RotateImage {
    /**
     * @see _0048_RotateImage.Solution02
     */
    class Solution {
        public void rotate(int[][] matrix) {
            int rowLow = 0, rowHigh = matrix.length - 1;
            while (rowLow < rowHigh) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int tmp = matrix[rowLow][j];
                    matrix[rowLow][j] = matrix[rowHigh][j];
                    matrix[rowHigh][j] = tmp;
                }
                rowLow++;
                rowHigh--;
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
     * 自己写出来的
     */
    class Solution03 {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix[0] == null || matrix[0].length == 0) {
                return;
            }
            int rowLow = 0, rowHigh = matrix.length - 1, colLow = 0, colHigh = matrix[0].length - 1;
            int curLen = rowHigh - rowLow;
            LinkedList<Integer> tmps = new LinkedList<>();
            while (curLen >= 1) {
                for (int j = 1; j <= curLen; j++) {
                    tmps.add(matrix[rowLow][colLow + j]);
                }
                for (int j = 1; j <= curLen; j++) {
                    matrix[rowLow][colLow + j] = matrix[rowHigh - j][colLow];
                }
                for (int i = 1; i <= curLen; i++) {
                    matrix[rowHigh - i][colLow] = matrix[rowHigh][colHigh - i];
                }
                for (int j = 1; j <= curLen; j++) {
                    matrix[rowHigh][colHigh - j] = matrix[rowLow + j][colHigh];
                }
                for (int i = 1; i <= curLen; i++) {
                    matrix[rowLow + i][colHigh] = tmps.removeFirst();
                }
                curLen -= 2;
                rowLow += 1;
                rowHigh -= 1;
                colLow += 1;
                colHigh -= 1;
            }
        }
    }

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
    class Solution02 {
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
