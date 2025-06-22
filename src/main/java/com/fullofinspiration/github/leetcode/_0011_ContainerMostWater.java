package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;


public class _0011_ContainerMostWater {

    /**
     * https://leetcode.cn/problems/3sum/solutions/284681/san-shu-zhi-he-by-leetcode-solution
     */
    class Solution {
        public int maxArea(int[] height) {
            int low = 0;
            int high = height.length - 1;
            int maxArea = 0;
            while (low < high) {
                int area = (high - low) * Math.min(height[low], height[high]);
                maxArea = Math.max(maxArea, area);
                if (height[low] < height[high]) {
                    low++;
                } else {
                    high--;
                }
            }
            return maxArea;
        }
    }

    /**
     * https://leetcode.com/problems/container-with-most-water/solutions/6100/simple-and-clear-proof-explanation/?orderBy=most_votes
     * m==n的情况下，这两个值只要在，都不可能存在更大的值，此时需要两个值都可以跳过
     */
    class Solution03 {
        public int maxArea(int[] height) {
            int max = Integer.MIN_VALUE;
            int low = 0, high = height.length - 1;
            while (low < high) {
                max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
                if (height[low] < height[high]) {
                    low++;
                } else if (height[low] > height[high]) {
                    high--;
                } else {
                    low++;
                    high--;
                }
            }
            return max;
        }
    }


    /**
     * 想不出来了
     * 该方法O(n)
     * 双指针：最左，最右，
     * if f(i+1,j) > f(i,j)(该值无用了){
     * i++
     * }  else if f(i,j-1)>f(i,j){
     * j--
     * }
     */
    class Solution02 {
        public int maxArea(int[] height) {
            throw new IllegalStateException();
        }
    }

    /**
     * 不需要中间结果，所以不需要dp，当前是O(n^2),直接穷举也能得到所有结果，不需要dp这么复杂
     * 超出最大内存限制了
     * f(i,j) = max{f(i+1,j-1), f(i+1,j), f(i,j-1), min(i,j)*(j-i)}
     * 需要注意j=i+1的cornerCase:此时i+1>j-1,等于0即可
     * debug 条件写错了，应该是f(i+1,j)而不是 f(i-1,j)
     */
    class Solution01 {
        public int maxArea(int[] height) {
            int[][] rst = new int[height.length + 1][height.length + 1];
            for (int i = height.length; i >= 1; i--) {
                for (int j = i + 1; j <= height.length; j++) {
                    rst[i][j] = Math.max(rst[i + 1][j - 1], rst[i + 1][j]);
                    rst[i][j] = Math.max(rst[i][j], rst[i][j - 1]);
                    rst[i][j] = Math.max(rst[i][j], Math.min(height[i - 1], height[j - 1]) * (j - i));
                }
            }
            return rst[1][height.length];
        }
    }

    /**
     * 看如何能盛下最多的水 我是参考了hint中才实现的，原来写的时间复杂度是O(n^2),参考的这篇时间复杂度是O(n)
     */
    class Solution00 {
        public int maxArea(int[] height) {
            int max = Integer.MIN_VALUE;
            int low = 0;
            int high = height.length - 1;
            while (low < high) {
                max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
                if (height[low] < high) {
                    low++;
                } else {
                    high--;
                }
            }
            return max;
        }
    }

    /**
     * 没有写完，这种方式太复杂了，而且没有必要
     */
    class Solution1 {
        public int maxArea(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            Map<Integer, Boolean> visited = new HashMap<>();
            for (int i = 0; i < height.length; i++) {
                visited.put(i, false);
            }
            int low = 0;
            int high = height.length - 1;
            visited.put(low, true);
            visited.put(high, true);
            int max = calcArea(height, low, high);
            while (low < high) {
                int leftMax = calcArea(height, low + 1, high);
                int rightMax = calcArea(height, low, low + 1);
                if (leftMax >= rightMax) {
                    visited.put(low, true);
                    low++;
                } else {
                    visited.put(high, true);
                    high = low + 1;
                }
                return -1;
            }
            return -1;
        }

        private int calcArea(int[] height, int left, int right) {
            return (right - left) * Math.min(height[left], height[right]);
        }
    }

    public int maxArea(int[] height) {
        int maxValue = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            maxValue = Math.max(maxValue, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxValue;
    }

}
