package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0054_SpiralMatrix {
    class Solution {
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
