package com.fullofinspiration.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _0739_FirstHigherTemperature {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ret = new int[temperatures.length];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = temperatures.length - 1; i >= 0; i--) {
                int val = temperatures[i];
                while (!stack.isEmpty() && temperatures[stack.peek()] <= val) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ret[i] = 0;
                    stack.push(i);
                    continue;
                }
                ret[i] = stack.peek() - i;
                stack.push(i);
            }
            return ret;
        }
    }
}
