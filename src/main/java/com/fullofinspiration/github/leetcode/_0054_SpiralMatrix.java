package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0054_SpiralMatrix {
    /**
     * https://leetcode.cn/problems/spiral-matrix/solutions/2362055/54-luo-xuan-ju-zhen-mo-ni-qing-xi-tu-jie-juvi
     */
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> all = new ArrayList<>();
            int rowLow = 0, rowHigh = matrix.length - 1;
            int colLow = 0, colHigh = matrix[0].length - 1;
            while (true) {
                for (int j = colLow; j <= colHigh; j++) {
                    all.add(matrix[rowLow][j]);
                }
                if (++rowLow > rowHigh) {
                    break;
                }
                for (int i = rowLow; i <= rowHigh; i++) {
                    all.add(matrix[i][colHigh]);
                }
                if (--colHigh < colLow) {
                    break;
                }
                for (int j = colHigh; j >= colLow; j--) {
                    all.add(matrix[rowHigh][j]);
                }
                if (--rowHigh < rowLow) {
                    break;
                }
                for (int i = rowHigh; i >= rowLow; i--) {
                    all.add(matrix[i][colLow]);
                }
                if (++colLow > colHigh) {
                    break;
                }
            }
            return all;
        }
    }

    class Solution00 {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return Collections.emptyList();
            }
            List<Integer> all = new ArrayList<>();
            int colBegin = 0;
            int colEnd = matrix[0].length - 1;
            int rowBegin = 0;
            int rowEnd = matrix.length - 1;
            while (colBegin <= colEnd && rowBegin <= rowEnd) {
                for (int i = colBegin; i <= colEnd; i++) {
                    all.add(matrix[rowBegin][i]);
                }
                rowBegin++;
                for (int i = rowBegin; i <= rowEnd; i++) {
                    all.add(matrix[i][colEnd]);
                }
                colEnd--;
                for (int i = colEnd; i >= colBegin && rowBegin <= rowEnd; i--) {
                    all.add(matrix[rowEnd][i]);
                }
                rowEnd--;
                for (int i = rowEnd; i >= rowBegin && colBegin <= colEnd; i--) {
                    all.add(matrix[i][colBegin]);
                }
                colBegin++;

            }
            return all;
        }
    }
}
