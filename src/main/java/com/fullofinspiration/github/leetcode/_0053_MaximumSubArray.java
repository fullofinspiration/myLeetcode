package com.fullofinspiration.github.leetcode;

/**
 * 方式1：
 * 1 遍历当前数组到末尾
 * 2 设置oldLow，遍历过程中如果当前加和小于oldMaxSum(因为有可能所有值都是小于0的，所以不能用0作为舍弃old low index的条件)，则舍弃old low，
 * 直到遍历到结尾
 * <p>
 * 方式2：
 * 采用分而治之的方式
 * 1 对数组中元素每两个一组，求得最大值
 * 2 对求得结果再两两一组，求得最大值，直到汇总所有自数组为1个为止
 */
public class _0053_MaximumSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int preMax = nums[0];
            int curSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (curSum < 0) {
                    curSum = nums[i];
                } else {
                    curSum += nums[i];
                }
                if (curSum > preMax) {
                    preMax = curSum;
                }
            }
            return preMax;
        }
    }
}
