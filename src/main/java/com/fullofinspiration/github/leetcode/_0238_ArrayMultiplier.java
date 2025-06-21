package com.fullofinspiration.github.leetcode;

public class _0238_ArrayMultiplier {
    /**
     * https://leetcode.cn/problems/product-of-array-except-self/solutions/272369/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-
     */
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] leftMultis = new int[nums.length];
            int[] rightMultis = new int[nums.length];
            leftMultis[0] = 1;
            rightMultis[nums.length - 1] = 1;
            for (int i = 1; i < nums.length; i++) {
                leftMultis[i]=leftMultis[i-1]*nums[i-1];
            }
            for (int i=nums.length-2;i>=0;i--) {
                rightMultis[i] = rightMultis[i+1]*nums[i+1];
            }
            for(int i=0;i<nums.length;i++){
                nums[i]=leftMultis[i]*rightMultis[i];
            }
            return nums;
        }
    }
}
