package com.fullofinspiration.github.leetcode;

import java.util.List;

public class _0152_MaxMultiplierSubArray {
    class Solution {
        public int maxProduct(int[] nums) {
            int ret = nums[0];
            int prevMaxMultiplier = nums[0];
            int prevMinMultiplier = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int prevMax = prevMaxMultiplier;
                int prevMin = prevMinMultiplier;
                int cur = nums[i];
                prevMaxMultiplier = Math.max(prevMax * cur,
                        Math.max(prevMin * cur, cur));
                prevMinMultiplier = Math.min(prevMax * cur,
                        Math.min(prevMin * cur, cur));
                ret = Math.max(ret,prevMaxMultiplier);
            }
            return ret;
        }
    }

    /**
     * 写不出来
     */
    class WrongSolution {
        public int maxProduct(int[] nums) {
            int[] maxValues = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                if (cur == 0) {
                    maxValues[i] = 0;
                    continue;
                }
                if (cur > 0) {
                    maxValues[i] = maxValues[i - 1] * i;
                    continue;
                }

            }
            return -1;
        }

    }
}
