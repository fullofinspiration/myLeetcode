package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0118_PascalIsTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> all = new ArrayList<>();
            ArrayList<Integer> first = new ArrayList<>();
            first.add(1);
            all.add(first);
            for (int i = 2; i <= numRows; i++) {
                List<Integer> cur = new ArrayList<>();
                List<Integer> prev = all.get(all.size() - 1);
                for (int j = 1; j <= i; j++) {
                    if (j == 1 || j == i) {
                        cur.add(1);
                        continue;
                    }
                    cur.add(prev.get(j - 2) + prev.get(j - 1));
                }
                all.add(cur);
            }
            return all;
        }
    }

    /**
     * 错误原因： 初始化时应该add(1) 而不是add(0)
     */
    class Solution00 {
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) {
                return Collections.emptyList();
            }
            List<List<Integer>> all = new ArrayList<>();
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1);
            all.add(cur);
            for (int i = 1; i < numRows; i++) {
                cur = new ArrayList<>();
                cur.add(1);
                List<Integer> pre = all.get(all.size() - 1);
                for (int j = 1; j < i; j++) {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
                cur.add(1);
                all.add(cur);
            }
            return all;
        }
    }
}
