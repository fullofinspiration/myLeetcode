package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0073_Matrix_MarkZero {
    class Solution {
        List<int[]> allZeros = new ArrayList<>();

        public void setZeroes(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return;
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        allZeros.add(new int[]{i, j});
                    }
                }
            }
            for (int[] idxs : allZeros) {
                int curI = idxs[0];
                int curJ = idxs[1];
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][curJ] = 0;
                }
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[curI][j] = 0;
                }
            }
        }

    }
}
