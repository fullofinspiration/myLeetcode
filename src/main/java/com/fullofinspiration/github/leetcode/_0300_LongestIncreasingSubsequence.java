package com.fullofinspiration.github.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _0300_LongestIncreasingSubsequence {
    /**
     * https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
     * 这个方法有些trick，但是确实符合动态规划的内容，时间复杂度O(nlogn)
     * 动态规划有点靠纯感觉
     * 那道判断链表是否有环（先快慢指针，相遇后另一个节点从起点开始，两个节点再次相遇节点即为环的起点，最开始我记错了，以为第一次相遇就是，这里也是想通过直觉面试，而不是通过严谨的论证，就是感觉错了）
     * 新建一个tails数组，若某个索引有值，则代表存在长度是i+1的连续递增子数组.
     * 过程：找到第一个大于该值的索引，如果不存在，则将该值追加到末尾，如果存在，则tails[i]可以由tails[i-1]和末尾的值来获得,所以可以更新该值，
     * 后边的值由于最小值已经比他大，所以不需要更新
     */
    public class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            // size这个地方很trick，是即将插入地方的索引，既代表size，有代表即将插入的位置，且该位置的初始值是0，
            // 由于所有值都是大于0的，所以即使最终到达该位置，也不会同num相比较
            int size = 0;
            for (int num : nums) {
                int low = 0, high = size;
                while (low != high) {
                    int mid = (low + high) / 2;
                    if (tails[mid] < num) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                tails[low] = num;
                if (low == size) {
                    size++;
                }
            }
            return size;
        }
    }

    /**
     * fn为包含当前值的最长元素 max为单独保存的结果 f(n)= max(f1,f2...fn-1) if array[n] > array[i]
     * 最后返回max
     */
    public class Solution01 {
        public int lengthOfLIS(int[] nums) {
            int[] ints = new int[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int cur = 0;
                for (int j = 0; j <= i; j++) {
                    if (nums[j] < nums[i]) {
                        cur = Math.max(cur, ints[j]);
                    }
                }
                ints[i] = cur + 1;
                max = Math.max(max, ints[i]);
            }
            return max;
        }
    }

    /**
     * 当前解法: O(n^2)
     */
    public class Solution00 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] counts = new int[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int max4CurIndex = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && counts[j] > max4CurIndex) {
                        max4CurIndex = counts[j];
                    }
                }
                counts[i] = max4CurIndex + 1;
                if (counts[i] > max) {
                    max = counts[i];
                }
            }
            return max;
        }
    }

    //错误的解法
    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            List<Data> datas = new LinkedList<>();
            Data curMaxData = new Data(nums[0], nums[0], 1);
            datas.add(curMaxData);
            for (int i = 1; i < nums.length; i++) {
                int curValue = nums[i];
                Iterator<Data> iterator = datas.iterator();
                while (iterator.hasNext()) {
                    Data curData = iterator.next();
                    if (curData.highValue < curValue) {
                        curData.length++;
                        curData.highValue = curValue;
                    }
                    if (curData.length > curMaxData.length) {
                        curMaxData = curData;
                    }
                    if (curData.length < curMaxData.length && curData.lowValue > curMaxData.lowValue) {
                        iterator.remove();
                    }
                }
                datas.add(new Data(curValue, curValue, 1));
            }
            return curMaxData.length;
        }

        private class Data {
            private final int lowValue;
            private int highValue;
            private int length;

            public Data(int lowValue, int highValue, int length) {
                this.lowValue = lowValue;
                this.highValue = highValue;
                this.length = length;
            }
        }
    }
}
