package com.fullofinspiration.github.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0349_IntersectionOfTwoArrays {
    /**
     * 1 遍历nums1,放入set1中
     * 2 遍历nums2，如果set1中，则放入，否则跳过
     */
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> nums1Set = new HashSet<>();
            for (int i : nums1) {
                nums1Set.add(i);
            }
            Set<Integer> rst = new HashSet<>();
            for (int i : nums2) {
                if (nums1Set.contains(i)) {
                    rst.add(i);
                }
            }
            return rst.stream().mapToInt(i -> i).toArray();
        }
    }
}
