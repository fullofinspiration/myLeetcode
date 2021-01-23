package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
  public static void main(String[] args) {
    //int[][] array= {{1,2,3},{4,5,6},{7,8,9}};
    int[][] array = {};
    spiralOrder(array);
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if (matrix.length == 0) {
      return list;
    }
    int m = matrix.length, n = matrix[0].length;
    boolean visited[][] = new boolean[m][n];
    int[] plusRow = {0, 1, 0, -1};
    int[] plusCol = {1, 0, -1, 0};
    int i = 0, j = 0, curPlusIndex = 0;
    for (int p = 0; p < m * n; p++) {
      list.add(matrix[i][j]);
      visited[i][j] = true;
      int nextRowIndex = i + plusRow[curPlusIndex];
      int nextColIndex = j + plusCol[curPlusIndex];
      if (nextRowIndex >= 0 && nextRowIndex < m && nextColIndex >= 0 && nextColIndex < n
          && !visited[nextRowIndex][nextColIndex]) {
        i = nextRowIndex;
        j=nextColIndex;
      } else {
        curPlusIndex = (curPlusIndex + 1) % 4;
        i += plusRow[curPlusIndex];
        j += plusCol[curPlusIndex];
      }

    }
    return list;
  }
}
