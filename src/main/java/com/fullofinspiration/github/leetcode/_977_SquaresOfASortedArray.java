package com.fullofinspiration.github.leetcode;

import java.util.Arrays;

public class _977_SquaresOfASortedArray {
    /**
     * https://leetcode.com/problems/squares-of-a-sorted-array/solutions/221922/java-two-pointers-o-n/?orderBy=most_votes
     */
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int lowIdx = 0, highIdx = nums.length - 1;
            int[] rst = new int[nums.length];
            for (int i = rst.length - 1; i >= 0; i--) {
                if (Math.pow(nums[lowIdx], 2) > Math.pow(nums[highIdx], 2)) {
                    rst[i] = (int) Math.pow(nums[lowIdx], 2);
                    lowIdx++;
                } else {
                    rst[i] = (int) Math.pow(nums[highIdx], 2);
                    highIdx--;
                }
//                System.out.println(Arrays.toString(rst));
            }
            return rst;
        }
    }

    /**
     * 写的太复杂了
     */
    class Solution01 {
        public int[] sortedSquares(int[] nums) {
            int lastNegtiveIdx = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    lastNegtiveIdx = i;
                }
                nums[i] *= nums[i];
            }
            int rst[] = new int[nums.length];
            int firstIdx = lastNegtiveIdx, secondIdx = lastNegtiveIdx + 1;
            for (int i = 0; i < rst.length; i++) {
                int firstVal = firstIdx < 0 ? Integer.MAX_VALUE : nums[firstIdx];
                int secondVal = secondIdx == nums.length ? Integer.MAX_VALUE : nums[secondIdx];
                int curVal = firstVal < secondVal ? nums[firstIdx--] : nums[secondIdx++];
                rst[i] = curVal;
            }
            return rst;
        }
    }
}
