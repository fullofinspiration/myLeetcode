package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0454_4SumII {
    /**
     * https://leetcode.com/problems/4sum-ii/solutions/1740606/going-from-o-n-4-o-n-3-o-n-2-java-c/?orderBy=most_votes
     * 首先最简单的方式是遍历四个数组时间复杂度O(n^4)，空间复杂度O(1)
     * 其次将最后一个数组放入hashmap中，时间复杂度O(n^3)， 空间复杂度O(n)
     * 最后将每两个一组，穷举所有的情况，放入到hashmap中，前一次每次都累加，
     * 后一次每次都递减，如果看到包含加和为0的元素，则结果递增，最后返回值，时间复杂度O(n^2), 空间复杂度O(2n)
     * 我开始想的可能通过数组排序+指针遍历的方式，这样可以使得空间复杂度为O(1), 但是没有想出来，原来是通过空间换时间的方式来解决问题
     */
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> num2Count = new HashMap<>();
            for (int i : nums1) {
                for (int j : nums2) {
                    Integer count = num2Count.getOrDefault(i + j, 0);
                    num2Count.put(i + j, count + 1);
                }
            }
            int count = 0;
            for (int i : nums3) {
                for (int j : nums4) {
                    int value = -(i + j);
                    if (num2Count.containsKey(value)) {
                        count += num2Count.get(value);
                    }
                }
            }
            return count;
        }
    }
}
