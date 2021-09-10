package com.fullofinspiration.github.leetcode;

public class _0042_TrappingRainWater {
    /**
     *  第一道hard题，而且是自己做出来的，一遍过，我太牛逼了
     */
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int[] leftMax = new int[height.length];
            int curMax = 0;
            for (int i = 1; i < height.length; i++) {
                curMax = Math.max(curMax, height[i - 1]);
                leftMax[i] = curMax;
            }
            curMax = 0;
            int[] rightMax = new int[height.length];
            for (int i = height.length - 2; i >= 0; i--) {
                curMax = Math.max(height[i + 1], curMax);
                rightMax[i] = curMax;
            }
            int totalSum = 0;
            for (int i = 0; i < height.length; i++) {
                int min = Math.min(leftMax[i], rightMax[i]);
                if (height[i] < min) {
                    totalSum = totalSum + min - height[i];
                }
            }
            return totalSum;

        }
    }
}
