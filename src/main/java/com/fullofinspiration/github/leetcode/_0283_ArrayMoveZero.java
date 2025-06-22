package com.fullofinspiration.github.leetcode;

public class _0283_ArrayMoveZero {
     class Solution {
        public void moveZeroes(int[] nums) {
            int zeroCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroCount++;
                    continue;
                }
                nums[i - zeroCount] = nums[i];
            }
            for (int i=0;i<zeroCount;i++) {
                nums[nums.length-i-1]=0;
            }
        }
    }
}
