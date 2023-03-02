package com.fullofinspiration.github.leetcode;

public class _0027_RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int cur = 0, pre = -1;
            while (cur < nums.length) {
                if (nums[cur] != val) {
                    nums[++pre] = nums[cur];
                }
                cur++;
            }
            return pre + 1;
        }
    }
}
