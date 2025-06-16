package com.fullofinspiration.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0084_LargestRectangleInHistogram {
    /**
     * 这方法太神奇了，能理解，但是不能想出来，背吧
     * https://leetcode.cn/problems/largest-rectangle-in-histogram/solutions/266844/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/comments/2258355/
     */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            Deque<Integer> queue = new ArrayDeque<>();
            queue.push(-1);
            int max = heights[0];
            for (int i = 0; i < heights.length; i++) {
                int cur = heights[i];
                while (!queue.isEmpty() && queue.peek() != -1 && heights[queue.peek()] >= cur) {
                    int area = heights[ queue.pop()] * (i - queue.peek() - 1);
                    max = Math.max(max, area);
                }
                queue.push(i);
            }
            while (!queue.isEmpty() && queue.peek() != -1) {
                int area = heights[ queue.pop()] * (heights.length - queue.peek()-1);
                max = Math.max(max, area);
            }
            return max;
        }
    }
}
