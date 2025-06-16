package com.fullofinspiration.github.leetcode;

public class _0169_MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;
            for (int num : nums) {
                if (num == candidate) {
                    count++;
                    continue;
                }
                if (count > 0) {
                    count--;
                    continue;
                }
                count++;
                candidate = num;
            }
            return candidate;
        }

    }

    class Solution00 {
        public int majorityElement(int[] nums) {
            int count = 0;
            int target = 0;
            for (int num : nums) {
                if (count == 0) {
                    count++;
                    target = num;
                } else if (num == target) {
                    count++;
                } else {
                    count--;
                }
            }
            return target;
        }
    }
}
