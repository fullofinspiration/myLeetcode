package com.fullofinspiration.github;

/**
 * 看如何能盛下最多的水
 * 我是参考了hint中才实现的，原来写的时间复杂度是O(n^2),参考的这篇时间复杂度是O(n)
 */
public class ContainerMostWater {
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

    public static void main(String[] args) {
        ContainerMostWater cms = new ContainerMostWater();
        int[] a = {1, 2, 1};
        int b = cms.maxArea(a);
        System.out.println(b);
    }
}
