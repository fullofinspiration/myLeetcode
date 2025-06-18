package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0051_NQueue {
    /**
     * 耗时2h
     * https://leetcode.cn/problems/n-queens/solutions/398929/nhuang-hou-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
     */
    class Solution {
        List<List<String>> rets = new ArrayList<>();
        int[] colIdxs;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();

        public List<List<String>> solveNQueens(int n) {
            colIdxs = new int[n];
            Arrays.fill(colIdxs, -1);
            traceback(n, 0);
            return rets;
        }

        private void traceback(int n, int row) {
            if (row == n) {
                List<String> ret = genRet(n);
                this.rets.add(ret);
            }
            for (int col = 0; col < n; col++) {
                if (cols.contains(col)) {
                    continue;
                }
                int diagonal1 = col - row;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + col;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                colIdxs[row] = col;
                cols.add(col);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                traceback(n, row + 1);
                colIdxs[row] = -1;
                cols.remove(col);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }

        private List<String> genRet(int n) {
            List<String> rets = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int queueColIdx = colIdxs[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != queueColIdx) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                rets.add(sb.toString());
            }
            return rets;
        }
    }

}
