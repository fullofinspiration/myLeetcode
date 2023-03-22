package com.fullofinspiration.github.leetcode;

public class _0198_Rob {
    /**
     * f(0) = nums[i]
     * f(1) = max(f(0), value(1))
     * f(n) = max{f(n-1), f(n-2)+ value(n)}
     * 错误点1: 应该是pre+nums[i] 而不是after+nums[i]
     * 错误点2：有两个数据时，应该选取其中较大的元素，不应该直接返回
     */
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int pre = 0;
            int after = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int cur = Math.max(after, pre + nums[i]);
                pre = after;
                after = cur;
            }
            return after;
        }
    }
}
