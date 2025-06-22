package com.fullofinspiration.github.leetcode;

public class _0042_TrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int leftMaxes[] = new int[height.length];
            int rightMaxes[] = new int[height.length];
            for (int i = 1; i < height.length; i++) {
                leftMaxes[i] = Math.max(leftMaxes[i - 1], height[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                rightMaxes[i] = Math.max(rightMaxes[i + 1], height[i + 1]);
            }
            int total = 0;
            for (int i = 0; i < height.length; i++) {
                int minVal = Math.min(leftMaxes[i], rightMaxes[i]);
                if (height[i] < minVal) {
                    total += (minVal - height[i]);
                }

            }
            return total;
        }
    }

    /**
     * 初始想法
     * 遍历每一层：
     * 第一层：1 找到第一个大于0的数，2 若下一个为0，则递增，若为1，则计算当前累计数量，并设置当前为起始点，直到遍历到最后一个节点
     * 遍历第二层，直至第n层
     * 时间复杂度high*n
     * 参考了Solution00后，发现可以将时间复杂度降低到O(n):
     * 1)查找每个节点左边最大的节点
     * 2)查找每个节点右边最大的节点
     * 3)遍历每个节点，取minVal = min(leftMax,rightMax),若cur< minVal,则total+=min-cur
     * 空间复杂度O(n),时间复杂度O(n)
     */
    class Solution01 {
        public int trap(int[] height) {
            int curMax = 0;
            int[] leftMax = new int[height.length];
            for (int i = 1; i < height.length; i++) {
                curMax = Math.max(curMax, height[i - 1]);
                leftMax[i] = curMax;
            }
            int[] rightMax = new int[height.length];
            curMax = 0;
            for (int i = height.length - 2; i >= 0; i--) {
                curMax = Math.max(curMax, height[i + 1]);
                rightMax[i] = curMax;
            }
            int total = 0;
            for (int i = 1; i < height.length - 1; i++) {
                int min = Math.min(leftMax[i], rightMax[i]);
                if (min > height[i]) {
                    total += min - height[i];
                }
            }
            return total;
        }
    }

    /**
     * 第一道hard题，而且是自己做出来的，一遍过，我太牛逼了
     */
    class Solution00 {
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
